/* Availability.java
   Availability POJO class
   Author: Hope Ringane (221174109)
   Date: 11 May 2025 */

package za.ac.cput.domain;

public class Availability {
    private String availabilityId;
    private String dayOfWeek;
    private String startTime;
    private String endTime;//endTime

    public Availability() {
    }

    public Availability(Builder builder) {
        this.availabilityId = builder.availabilityId;
        this.dayOfWeek = builder.dayOfWeek;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public String getAvailabilityId() {
        return availabilityId;
    }

    public String getdayOfWeek() {
        return dayOfWeek;
    }

    public String getstartTime() {
        return startTime;
    }

    public String getendTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "availabilityId='" + availabilityId + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public static class Builder {

        private String availabilityId;
        private String dayOfWeek;
        private String startTime;
        private String endTime;

        public Builder setAvailabilityId(String availabilityId) {
            this.availabilityId = availabilityId;
            return this;
        }

        public Builder setdayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        public Builder setstartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setendTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Availability build() {
            return new Availability(this);
        }
    }
}