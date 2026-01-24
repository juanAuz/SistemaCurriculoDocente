package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelo.Docente;

public class DocentePersistencia {
    public static final String RUTA = "docente.dat";
    public static void guardar(Docente docente){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA));
            //hacemos copias de los observable list y los metemos en list normales que si se guardan en el .dat
            serializarListas(docente);
            oos.writeObject(docente);
            System.out.println("Docente guardado correctamente"); //esto luego se mete en la GUI
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Docente cargar(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA));
            Docente docente = (Docente) ois.readObject();
            // reconstruimos las colleciones de la GUI
            recuperarListas(docente);
            System.out.println("Datos cargados correctamente");
            ois.close();
            return docente;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Docente();
        }
    }
    public static void serializarListas(Docente docente){
        docente.setTitulosSerializable(docente.getTituloGuardar());
        docente.setCapacitacionesSerializable(docente.getCapacitacionesGuardar());
        docente.setExperienciaSerializable(docente.getExperienciaGuardar());
        docente.setPublicacionesSerializable(docente.getPublicacionesGuardar());
        docente.setInvestigacionesSerializable(docente.getInvestigacionesGuardar());
    }
    public static void recuperarListas(Docente docente){
        docente.setCapacitacionesCargar(docente.getCapacitacionesSerializable());
        docente.setTitulosCargar(docente.getTitulosSerializable());
        docente.setExperienciaCargar(docente.getExperienciaSerializable());
        docente.setPublicacionesCargar(docente.getPublicacionesSerializable());
        docente.setInvestigacionesCargar(docente.getInvestigacionesSerializable());
    }
}
