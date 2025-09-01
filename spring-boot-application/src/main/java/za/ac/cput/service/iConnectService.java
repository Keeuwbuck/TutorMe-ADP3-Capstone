package za.ac.cput.service;
/*Keewan Titus
230778577
 */
import za.ac.cput.model.Connect;

import java.util.List;

public interface iConnectService {
    List<Connect> getAllConnect();
    Connect createConnect(Connect connect);

    void deleteConnect(Long id) throws Exception;
}
