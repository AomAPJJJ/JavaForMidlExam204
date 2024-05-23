package sit.int204.finalpee2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sit.int204.finalpee2.services.FileService;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping("/test")
    public ResponseEntity<Object> testPropertiesMapping() {
        //        return ResponseEntity.ok(fileStorageProperties.getUploadDir()); // -> ./product-images
        return ResponseEntity.ok(fileService.getFileStorageLocation()); // -> "file:///Users/bunnymoon/Desktop/java/pee2/ForJavaINT204/finalpee2/product-images/"

//        return ResponseEntity.ok("Upload Folder (Directory) is \"" + fileStorageProperties.getUploadDir()
//                + "\n" +"Host Name is \"" + fileStorageProperties.getFileServiceHostName()+ "\""
//                + "\n" + fileService.getFileStorageLocation() + " has been created !!!");
    }

    @PostMapping("")
    public ResponseEntity<Object> fileUpload(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return ResponseEntity.ok("You successfully uploaded " + file.getOriginalFilename()); // -> You successfully uploadedlogo.png
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileService.loadFileAsResource(filename);
        String fileName = file.getFilename();
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        switch (extension) {
            case ".pdf":
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(file);
            case ".png":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(file);
            case ".jpeg":
            case ".jpg":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
            case ".gif":
            case ".jfif":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF).body(file);
            default:
                return ResponseEntity.ok().contentType(MediaType.ALL).body(file); //ต้องเช็ค file type
        }
    }

    @DeleteMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<String> removeFile(@PathVariable String filename) {
        fileService.removeResource(filename);
        return ResponseEntity.ok(filename + " has been delete !!!");
    }

    // List all files
    @GetMapping("/list")
    public ResponseEntity<List<String>> listAllFiles() {
        List<String> fileNames = fileService.getAllFiles();
        return ResponseEntity.ok(fileNames);
    }
}


//    @GetMapping("/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//        Resource file = fileService.loadFileAsResource(filename);
//        String fileName = file.getFilename();
//        String extension = fileName.substring(fileName.lastIndexOf('.'));
//        if (extension.equalsIgnoreCase("pdf")){
//            return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(file);
//        } else {
//            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
//        }
//    }

//    @GetMapping("/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Object> serveFile(@PathVariable String filename){
//        Resource file = fileService.loadFileAsResource(filename);
//        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
//    }

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        try {
//            String fileName = fileService.store(file);
//            return ResponseEntity.ok("File uploaded successfully: " + fileName);
//        } catch (RuntimeException ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }

