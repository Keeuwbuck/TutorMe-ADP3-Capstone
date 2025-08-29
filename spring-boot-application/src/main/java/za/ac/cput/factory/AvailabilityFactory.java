
package za.ac.cput.factory;
/*  AvailabilityFactory.java
    Availability Factory class
    Author: Hope Ringane (221174109)
    Date: 18 May 2025
 */
import za.ac.cput.domain.Availability;
import za.ac.cput.util.Helper;

public class AvailabilityFactory {
    public static Availability createAvailability(String dayOfWeek, String startTime, String endTime) {

        String availabilityId = Helper.generateId();

        return new Availability.Builder()
                .setAvailabilityId(availabilityId)
                .setdayOfWeek(dayOfWeek)
                .setstartTime(startTime)
                .setendTime(endTime)
                .build();
    }
}
