package ro.ubb.racheta.validation;


import ro.ubb.racheta.domain.Nota;
import ro.ubb.racheta.domain.Student;
import ro.ubb.racheta.domain.Tema;
import ro.ubb.racheta.repository.StudentXMLRepo;
import ro.ubb.racheta.repository.TemaXMLRepo;

public class NotaValidator implements Validator<Nota> {
    private StudentXMLRepo studentFileRepository;
    private TemaXMLRepo temaFileRepository;

    /**
     * Class constructor
     * @param studentFileRepository - ro.ubb.racheta.repository student
     * @param temaFileRepository - ro.ubb.racheta.repository tema
     */
    public NotaValidator(StudentXMLRepo studentFileRepository, TemaXMLRepo temaFileRepository) {
        this.studentFileRepository = studentFileRepository;
        this.temaFileRepository = temaFileRepository;
    }

    /**
     * Valideaza o nota
     * @param nota - nota pe care o valideaza
     * @throws ValidationException daca nota nu e valida
     */
    @Override
    public void validate(Nota nota) throws ValidationException {
        Student student = studentFileRepository.findOne(nota.getIdStudent());
        if (student== null){
            throw new ValidationException("Studentul nu exista!");
        }
        Tema tema = temaFileRepository.findOne(nota.getIdTema());
        if(tema == null){
            throw new ValidationException("Tema nu exista!");
        }
        double notaC = nota.getNota();
        if(notaC > 10.00 || notaC < 0.00){
            throw new ValidationException("Valoarea notei nu este corecta!");
        }
    }
}
