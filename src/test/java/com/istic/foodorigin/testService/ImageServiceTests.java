package com.istic.foodorigin.testService;

import com.istic.foodorigin.service.ImageService;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link ImageService}
 */
@SpringBootTest
public class ImageServiceTests {

    @Autowired
    private ImageService imageService;

    @Test
    public void testSaveOnImageServer() throws IOException {
        Long id = Integer.toUnsignedLong(5);
        File image = new File("..\\foodorigintransp.png");
        FileInputStream input = new FileInputStream(image);
        MultipartFile file = new MockMultipartFile("fileItem", image.getName(), "image/png", IOUtils.toByteArray(input));
        boolean ret = this.imageService.saveImageOnServer(file, id);
        assertThat(ret).isTrue();
    }

    @Test
    public void testSaveOnImageServerTransfoNotExists() throws IOException {
        Long id = Integer.toUnsignedLong(0);
        File image = new File("..\\foodorigintransp.png");
        FileInputStream input = new FileInputStream(image);
        MultipartFile file = new MockMultipartFile("fileItem", image.getName(), "image/png", IOUtils.toByteArray(input));
        boolean ret = this.imageService.saveImageOnServer(file, id);
        assertThat(ret).isFalse();
    }

    @Test
    public void testFolderFilesExist() throws IOException {
        Long id = Integer.toUnsignedLong(1);
        Set<String> files = imageService.getFolderFiles(id);
        ArrayList<String> filesL = new ArrayList<>(files);
        assertThat(files.size()).isEqualTo(3);
    }

    @Test
    public void testFolderFilesNotExists() {
        Long id = Integer.toUnsignedLong(21000);
        Set<String> files = imageService.getFolderFiles(id);
        assertThat(files.size()).isEqualTo(0);
    }

    @Test
    public void testFolderFilesNull() {
        Set<String> files = imageService.getFolderFiles(null);
        assertThat(files.size()).isEqualTo(0);
    }

    @Test
    public void testRemoveFileExist() {
        Long id = Integer.toUnsignedLong(5);
        String fileName = "foodorigintransp.png";
        boolean isDeleted = this.imageService.removeFile(id, fileName);
        assertThat(isDeleted).isTrue();
    }

    @Test
    public void testRemoveFileNotExist() {
        Long id = Integer.toUnsignedLong(0);
        String fileName = "foodorigintransp2.png";
        boolean isDeleted = this.imageService.removeFile(id, fileName);
        assertThat(isDeleted).isFalse();
    }

    @Test
    public void testRemoveFileIdNotExist() {
        Long id = Integer.toUnsignedLong(21000);
        String fileName = "foodorigintransp.png";
        boolean isDeleted = this.imageService.removeFile(id, fileName);
        assertThat(isDeleted).isFalse();
    }

    @Test
    public void testRemoveFileIdAFileNotExist() {
        Long id = Integer.toUnsignedLong(21000);
        String fileName = "foodorigintransp2.png";
        boolean isDeleted = this.imageService.removeFile(id, fileName);
        assertThat(isDeleted).isFalse();
    }

}
