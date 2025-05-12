package za.ac.cput.domain;

/* Tutor.java
      Tutor POJO class
     Author: Henzley Spogter (230013309)
     Date: 11 May 2025
     */


public class Tutor {
    private int tutorID;
    private double hourlyRate;
    private String bio;
    private double averageRating;
    private boolean verificationStatus;

    //Default constructor
    public Tutor() {

    }

    //Parameterised constructor
    private Tutor(TutorBuilder builder) {
        this.tutorID = builder.tutorID;
        this.hourlyRate = builder.hourlyRate;
        this.bio = builder.bio;
        this.averageRating = builder.averageRating;
        this.verificationStatus = builder.verificationStatus;
    }

    public int getTutorID() {
        return tutorID;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getBio() {
        return bio;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public boolean isVerificationStatus() {
        return verificationStatus;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorID=" + tutorID +
                ", hourlyRate=" + hourlyRate +
                ", bio='" + bio + '\'' +
                ", averageRating=" + averageRating +
                ", verificationStatus=" + verificationStatus +
                '}';
    }

    public static class TutorBuilder {
        private int tutorID;
        private double hourlyRate;
        private String bio;
        private double averageRating;
        private boolean verificationStatus;

        public TutorBuilder(int tutorID, double hourlyRate, String bio, double averageRating, boolean verificationStatus) {
            this.tutorID = tutorID;
            this.hourlyRate = hourlyRate;
            this.bio = bio;
            this.averageRating = averageRating;
            this.verificationStatus = verificationStatus;
        }

        public TutorBuilder setTutorID(int tutorID) {
            this.tutorID = tutorID;
            return this;
        }

        public TutorBuilder setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        public TutorBuilder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public TutorBuilder setAverageRating(double averageRating) {
            this.averageRating = averageRating;
            return this;
        }

        public TutorBuilder setVerificationStatus(boolean verificationStatus) {
            this.verificationStatus = verificationStatus;
            return this;
        }

        public Tutor build() {
            return new Tutor(this);
        }
    }
}
