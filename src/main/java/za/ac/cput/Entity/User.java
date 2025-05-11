/* User.java
   User POJO class
   Author: Hope Ringane (221174109)
   Date: 11 May 2025 */

package za.ac.cput.Entity;



public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private Long idNumber;
    private String phoneNumber;
    private String email;
    private String password;

    public User() {
    }



    public User(Builder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.idNumber = builder.idNumber;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return firstName;
    }

    public String getUserSurname() {
        return lastName;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + firstName + '\'' +
                ", userSurname='" + lastName + '\'' +
                ", idNumber=" + idNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static class Builder {
        private String userId;
        private String firstName;
        private String lastName;
        private Long idNumber;
        private String phoneNumber;
        private String email;
        private String password;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setIdNumber(Long idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder copy(User user) {
            this.userId = user.userId;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.idNumber = user.idNumber;
            this.phoneNumber = user.phoneNumber;
            this.email = user.email;
            this.password = user.password;
            return this;

        }
        public User build() {
            return new User(this);
        }
    }

}


