package za.ac.cput.domain;

/* Tutor.java
      Tutor POJO class
     Author: Henzley Spogter (230013309)
     Date: 11 May 2025
     */
public class Tutor extends User {
    private String tutorID;
    private double hourlyRate;
    private String bio;
    private double averageRating;
    private boolean verificationStatus;

    //Default constructor
    public Tutor() {
        super();
    }

    //Parameterised constructor
    private Tutor(TutorBuilder builder) {

        // to construct a User object
        super(new UserBuilder()
                .setUserId(builder.userId)
                .setFirstName(builder.firstName)
                .setLastName(builder.lastName)
                .setPhoneNumber(builder.phoneNumber)
                .setEmail(builder.email)
                .setPassword(builder.password));

        this.tutorID = builder.tutorID;
        this.hourlyRate = builder.hourlyRate;
        this.bio = builder.bio;
        this.averageRating = builder.averageRating;
        this.verificationStatus = builder.verificationStatus;
    }

    public String getTutorID() {
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
        // add User toString() method
        return super.toString() +
                "Tutor{" + "tutorID=" + tutorID + "," +
                " hourlyRate=" + hourlyRate + "," +
                " bio='" + bio + '\'' +
                ", averageRating=" + averageRating +
                ", verificationStatus=" + verificationStatus + '}';
    }

    // Implementation of builder class
    public static class TutorBuilder extends UserBuilder {

        private String tutorID;
        private double hourlyRate;
        private String bio;
        private double averageRating;
        private boolean verificationStatus;

        public TutorBuilder(String tutorID,
                            double hourlyRate,
                            String bio,
                            double averageRating,
                            boolean verificationStatus) {
            this.tutorID = tutorID;
            this.hourlyRate = hourlyRate;
            this.bio = bio;
            this.averageRating = averageRating;
            this.verificationStatus = verificationStatus;
        }

        public TutorBuilder() {

        }

        @Override
        public TutorBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public TutorBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public TutorBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public TutorBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public TutorBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public TutorBuilder setPassword(String password) {
            this.password = password;
            return this;
        }


        public TutorBuilder setTutorID(String tutorID) {
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


        public TutorBuilder copy(Tutor tutor) {
            this.tutorID = tutor.tutorID;
            this.hourlyRate = tutor.hourlyRate;
            this.bio = tutor.bio;
            this.averageRating = tutor.averageRating;
            this.verificationStatus = tutor.verificationStatus;
            return this;
        }

        public Tutor build() {
            return new Tutor(this);
        }
    }
}
