package br.com.drivesender.controller;
import br.com.drivesender.service.GoogleDriveService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("drive")
public class GoogleDriveController {

    final GoogleDriveService service;

    public GoogleDriveController(GoogleDriveService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("arquivo") MultipartFile file) {
        try {
            return service.uploadFile(file);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}