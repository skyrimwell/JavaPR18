package app.Application.Controllers;

import app.Application.Classes.Manufacture;
import app.Application.Classes.Phone;
import app.Application.Services.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ManufactureController {
    @Autowired
    private ManufactureService manufactureService;

    @PostMapping("/manufactures")
    public void addManufacture(@RequestBody Manufacture manufacture) {
        manufactureService.addManufacture(manufacture);
    }

    @GetMapping("/manufactures")
    public List<Manufacture> getAll() {
        return manufactureService.getManufactures();
    }

    @DeleteMapping("/manufacture/{id}")
    public void delete(@PathVariable UUID id) {
        manufactureService.deleteManufacture(id);
    }

    @GetMapping(value = "/manufacture/{id}/phone")
    public @ResponseBody
    Phone getGame(@PathVariable("id") UUID id) {
        return manufactureService.getUserByManufacture(id);
    }
}
