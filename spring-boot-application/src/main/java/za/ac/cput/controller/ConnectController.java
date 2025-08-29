package za.ac.cput.controller;
/*Keewan Titus
230778577
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.model.ApiResponse;
import za.ac.cput.model.Connect;
import za.ac.cput.service.ConnectService;

import java.util.List;

@RestController
public class ConnectController {
    @Autowired
    private ConnectService connectService;

    @GetMapping("/api")
    public ApiResponse homeController() {
        ApiResponse response = new ApiResponse();
        response.setMessage("Welcome to Api");
        response.setStatus(true);
        return response;
    }
    @GetMapping("/api/connect")
    public List<Connect> getAllConnect() {
        return connectService.getAllConnect();
    }

    @PostMapping("/api/connect")
    public Connect createConnect(@RequestBody Connect connect) {
        return connectService.createConnect(connect);


    }
    @DeleteMapping("api/connect/{id}")
    public ApiResponse deleteConnect(@PathVariable Long id) throws Exception {
         connectService.deleteConnect(id);
        ApiResponse response = new ApiResponse();
        response.setMessage("Connect deleted");
        response.setStatus(true);
         return response;


    }
}