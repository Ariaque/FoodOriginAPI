package com.istic.foodorigin.service;


import com.istic.foodorigin.repository.TransformateurRepository;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Set;

/**
 * Class which allows to make operations on the remote FTP server.
 */
@Service
public class ImageService {

    @Value("${foodOrigin.server.user}")
    private String user;
    @Value("${foodOrigin.server.address}")
    private String ftp_address;
    @Value("${foodOrigin.server.password}")
    private String mdp;

    @Autowired
    private TransformateurRepository transformateurRepository;

    public boolean saveImageOnServer(MultipartFile file, Long idT) {
        boolean ret = false;
        if (idT != null && transformateurRepository.findById(idT).isPresent() && file != null) {
            FTPClient con = null;
            try {
                con = new FTPClient();
                con.connect(this.ftp_address);
                if (con.login(this.user, this.mdp) && !file.isEmpty()) {
                    con.enterLocalPassiveMode();
                    con.setFileType(FTP.BINARY_FILE_TYPE);
                    con.changeWorkingDirectory("/images");
                    con.makeDirectory(idT.toString());
                    con.changeWorkingDirectory(idT.toString());
                    ret = con.storeFile(file.getOriginalFilename(), file.getInputStream());
                    con.logout();
                    con.disconnect();
                }
            } catch (Exception e) {
                System.out.println("Erreur " + e);
            }
        }
        return ret;
    }

    public Set<String> getFolderFiles(Long idT) {
        Set<String> images = new HashSet<>();
        if (idT != null && transformateurRepository.findById(idT).isPresent()) {
            FTPClient con = null;
            try {
                con = new FTPClient();
                con.connect(this.ftp_address);
                if (con.login(this.user, this.mdp)) {
                    con.enterLocalPassiveMode();
                    con.setFileType(FTP.BINARY_FILE_TYPE);
                    con.changeWorkingDirectory("/images");
                    if (con.changeWorkingDirectory(idT.toString())) {
                        con.changeWorkingDirectory(idT.toString());
                        FTPFile[] files = con.listFiles();
                        for (int i = 2; i < files.length; i++) {
                            images.add(files[i].getName());
                        }
                    }
                    con.logout();
                    con.disconnect();
                }
            } catch (Exception e) {
                System.out.println("Erreur " + e);
            }
        }
        return images;
    }

    public boolean removeFile(Long idT, String fileName) {
        boolean ret = false;
        if (idT != null && transformateurRepository.findById(idT).isPresent() && fileName != null) {
            FTPClient con = null;
            try {
                con = new FTPClient();
                con.connect(this.ftp_address);
                if (con.login(this.user, this.mdp)) {
                    con.enterLocalPassiveMode();
                    con.setFileType(FTP.BINARY_FILE_TYPE);
                    con.changeWorkingDirectory("/images");
                    con.changeWorkingDirectory(idT.toString());
                    ret = con.deleteFile(fileName);
                    con.logout();
                    con.disconnect();
                }
            } catch (Exception e) {
                System.out.println("Erreur " + e);
            }
        }
        return ret;
    }
}
