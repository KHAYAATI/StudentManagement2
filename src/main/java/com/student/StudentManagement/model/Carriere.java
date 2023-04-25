package com.student.StudentManagement.model;

import com.student.StudentManagement.enumurations.Diplomat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "carriere")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carriere {

    @Embeddable
    public static class CarriereId implements Serializable {

        @Column(name = "fk_student")
        protected Long studentId;

        @Enumerated(EnumType.STRING)
        protected Diplomat diplomeId;
        public CarriereId(Long studentId,  Diplomat diplomeId) {
            this.studentId = studentId;
            this.diplomeId = diplomeId;
        }

        public CarriereId() {

        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((studentId == null) ? 0 : studentId.hashCode());
            result = prime * result
                    + ((diplomeId == null) ? 0 : diplomeId.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            CarriereId other = (CarriereId) obj;

            if (studentId == null) {
                if (other.studentId != null)
                    return false;
            } else if (!studentId.equals(other.studentId))
                return false;

            if (diplomeId == null) {
                if (other.diplomeId != null)
                    return false;
            } else if (!diplomeId.equals(other.diplomeId))
                return false;

            return true;
        }
    }

    @EmbeddedId
    private CarriereId idCarr;

    @ManyToOne
    @JoinColumn(name = "fk_student", insertable = false, updatable = false)
    private Student student;
    @Column
    @Enumerated(EnumType.STRING)
    private Diplomat diplomat;

}
