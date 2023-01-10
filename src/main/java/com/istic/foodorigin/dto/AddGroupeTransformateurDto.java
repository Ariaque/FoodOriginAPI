package com.istic.foodorigin.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.istic.foodorigin.models.GroupeTransformateur} entity
 */
public class AddGroupeTransformateurDto implements Serializable {
    private final Set<Long> labelIds;
    private String description;

    public AddGroupeTransformateurDto() {
        this.labelIds = new HashSet<>();
    }

    public AddGroupeTransformateurDto(Set<Long> labelIds, String description) {
        this.labelIds = labelIds;
        this.description = description;
    }

    public Set<Long> getLabelIds() {
        return labelIds;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddGroupeTransformateurDto entity = (AddGroupeTransformateurDto) o;
        return Objects.equals(this.labelIds, entity.labelIds) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labelIds, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "labelIds = " + labelIds + ", " +
                "description = " + description + ")";
    }
}
