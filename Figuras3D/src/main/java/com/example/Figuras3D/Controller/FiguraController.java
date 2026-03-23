package com.example.Figuras3D.Controller;

import com.example.Figuras3D.Model.FiguraModel;
import java.util.ArrayList;
//Extensiones para usar los metodos HTTP y demas
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // annotación para que spring boot sepa que esta clase es un controlador
@RequestMapping("/api")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*") // sirve para permitir la comunicación con la pagina web
public class FiguraController {

    ArrayList<FiguraModel> catalogo = new ArrayList<FiguraModel>();

    public FiguraController() {
        // valores que llenan el arraylist y simula una "base de datos" con eso trabajaremos la API
        catalogo.add(new FiguraModel(1001, "Batman", "caballero oscuro", "figura de acción", 12, 4, 4, true, true));
        catalogo.add(new FiguraModel(1002, "Iron Man", "traje Mark 85", "figura de acción", 13, 5, 4, true, true));
        catalogo.add(new FiguraModel(1003, "Spider-Man", "traje clásico", "figura de acción", 11, 3, 3, true, false));
        catalogo.add(new FiguraModel(1004, "Hulk", "versión vengadores", "figura de acción", 14, 6, 5, true, true));
        catalogo.add(new FiguraModel(1005, "Thor", "dios del trueno", "figura de acción", 13, 5, 4, true, false));
        catalogo.add(new FiguraModel(1006, "Capitán América", "con escudo", "figura de acción", 12, 4, 4, true, true));
        catalogo.add(new FiguraModel(1007, "Flash", "velocidad máxima", "figura de acción", 12, 3, 3, true, true));
        catalogo.add(new FiguraModel(1008, "Wonder Woman", "princesa amazona", "figura de acción", 13, 4, 4, true, false));
        catalogo.add(new FiguraModel(1009, "Deadpool", "mercenario bocón", "figura de acción", 12, 4, 3, true, true));
        catalogo.add(new FiguraModel(1010, "Wolverine", "garras de adamantium", "figura de acción", 11, 4, 3, true, false));
        catalogo.add(new FiguraModel(1011, "Goku", "super saiyajin", "coleccionable", 15, 6, 5, true, true));
        catalogo.add(new FiguraModel(1012, "Vegeta", "orgullo saiyajin", "coleccionable", 14, 5, 4, true, false));
        catalogo.add(new FiguraModel(1013, "Naruto", "modo sabio", "coleccionable", 13, 4, 4, true, true));
        catalogo.add(new FiguraModel(1014, "Sasuke", "sharingan", "coleccionable", 13, 4, 4, true, false));
        catalogo.add(new FiguraModel(1015, "Luffy", "gear 5", "coleccionable", 14, 5, 4, true, true));
        catalogo.add(new FiguraModel(1016, "Zoro", "espadachín", "coleccionable", 14, 5, 4, true, false));
        catalogo.add(new FiguraModel(1017, "Ichigo", "bankai", "coleccionable", 15, 5, 4, true, true));
        catalogo.add(new FiguraModel(1018, "Tanjiro", "cazador de demonios", "coleccionable", 13, 4, 3, true, true));
        catalogo.add(new FiguraModel(1019, "Nezuko", "forma demonio", "coleccionable", 12, 3, 3, true, false));
        catalogo.add(new FiguraModel(1020, "Gojo", "hechicero", "coleccionable", 14, 5, 4, true, true));
    }

    //Metodos HTTP
    // metodo GET que Muestra todo el catalogo de las figuras que contiene el ArrayList
    @GetMapping("/catalogo")
    public ArrayList<FiguraModel> CatalogoFiguras3D() {
        return catalogo;
    }

    // consulta una figura en especifico del catalogo mediante id
    @GetMapping("/catalogo/{id}")
    public FiguraModel BusquedaFigura(@PathVariable long id) { //se usa el @pathvariable para traer un valor por la url de la consulta
        // se realiza un foreach para recorrer todas las figuras y hallar el id de la figura deseada
        for (FiguraModel baseDatosFiguras : catalogo) {
            if (baseDatosFiguras.getId() == id) {
                return baseDatosFiguras;
            }
        }
        return null; // se retorna null porque no lo encontro, no es recomendable eso pero asi funciona pero tienes que
        //preparar tu puente js para que lo soporte ojo porque eso puede causar fallos
    }

    // Metodo POST que crea o añade una figura al catalogo
    @PostMapping("/catalogo")
    public FiguraModel AñadirFigura3D(@RequestBody FiguraModel figuras) { // se usa el @RequestBody para poder mandar un valor 
        //mediante el cuerpo de la consulta muy importante
        for (FiguraModel data : catalogo) { // se recorre con un foreach el arraylist
            if (data.getId() == figuras.getId()) { // esto es para evitar que se agregue una figura si se ingresa un ID que ya este registrado
                return null;
            }
        }
        //en caso de que no encuentre el ID lo añade normal
        catalogo.add(figuras);
        return figuras;
    }

    // Metodo PUT y Actualiza una figura completamente del catalogo
    @PutMapping("/catalogo")
    public FiguraModel ActualizarFigura3D(@RequestBody FiguraModel figura) { // se envia un nuevo objeto mediante la consulta
        //se recorre la lista hasta hallar la figura, luego se reemplaza
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getId() == figura.getId()) {
                catalogo.set(i, figura);
                return figura; // re retorna el objeto 
            }
        }
        return null; // en caso de no encontrar devuelve null
    }

    //Metodo DELETE y sirve para Eliminar una figura del catalogo
    @DeleteMapping("/catalogo/{id}")
    public FiguraModel EliminarFigura3D(@PathVariable long id) {
        for (FiguraModel dataFigura : catalogo) {
            if (dataFigura.getId() == id) {
                catalogo.remove(dataFigura);
                return dataFigura;
            }
        }
        return null;
    }
}
