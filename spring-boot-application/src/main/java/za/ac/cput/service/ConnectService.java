package za.ac.cput.service;
/*Keewan Titus
230778577
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.model.Connect;
import za.ac.cput.repository.ConnectRepository;

import java.util.List;
@Service
public class ConnectService implements iConnectService {
    @Autowired
    private ConnectRepository connectRepository;


    @Override
    public List<Connect> getAllConnect() {
        return connectRepository.findAll();
    }

    @Override
    public Connect createConnect(Connect connect) {
        return connectRepository.save(connect);
    }

    @Override
    public void deleteConnect(Long id) throws Exception {
        Connect connect =connectRepository.findById(id).orElseThrow(()->new Exception("The Connect does not exist"));
        connectRepository.deleteById(id);

    }
}
