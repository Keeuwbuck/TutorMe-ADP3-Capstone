package za.ac.cput.Factory;

import za.ac.cput.domain.Availability;

public class AvailabilityFactory {

    private static Availability createAvailability( String availabilityId, String dayOfWeek, String startTime, String endTime){

        if(Helper.isNullOrEmpty(availabilityId))
            return null;
        if(Helper.isNullOrEmpty(dayOfWeek))
            return null;
        if(Helper.isNullOrEmpty(startTime))
            return null;
        if(Helper.isNullOrEmpty(endTime))
            return null;

        return new Availability.Builder()
                .setAvailabilityId(availabilityId)
                .setdayOfWeek(dayOfWeek)
                .setstartTime(startTime)
                .setendTime(endTime)
                .build();

    }
}
