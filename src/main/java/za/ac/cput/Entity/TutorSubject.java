package za.ac.cput.Entity;
/* TutorSubject.java

     TutorSubject POJO class

     Author: Keewan Titus (230778577)

     Date: 04 May 2025 */
public class TutorSubject {
    private String studentSubjectId;
    private String proficiencyLevel;
    private double spesializedRate;

    private  TutorSubject(TutorSubjectBuilder builder) {
        this.studentSubjectId = builder.studentSubjectId;
        this.proficiencyLevel = builder.proficiencyLevel;
        this.spesializedRate = builder.spesializedRate;



    }

    public String getStudentSubjectId() {
        return studentSubjectId;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public double getSpesializedRate() {
        return spesializedRate;
    }
    @Override
    public String toString() {
        return "TutorSubject+ " + studentSubjectId+ ", " +
                "proficiencyLevel=" + proficiencyLevel + ", spesializedRate=" + spesializedRate;


    }
    public static class TutorSubjectBuilder {
        private String studentSubjectId;
        private String proficiencyLevel;
        private double spesializedRate;

        public TutorSubjectBuilder setStudentSubjectId(String studentSubjectId) {
            this.studentSubjectId = studentSubjectId;
            return this;


        }

        public TutorSubjectBuilder setProficiencyLevel(String proficiencyLevel) {
            this.proficiencyLevel = proficiencyLevel;
            return this;

        }

        public TutorSubjectBuilder setSpesializedRate(double spesializedRate) {
            this.spesializedRate = spesializedRate;
            return this;
        }
        public TutorSubject build() {
            return new TutorSubject(this);
        }
    }
}
