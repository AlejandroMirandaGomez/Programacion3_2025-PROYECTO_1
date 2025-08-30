package proyecto_1.data;

import proyecto_1.logic.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Receta> recetas;
    private List<Medicamento> medicamentos;

    public Data() {
        medicos = new ArrayList<>();
        recetas = new ArrayList<>();
        pacientes = new ArrayList<>();
        medicamentos = new ArrayList<>();

        seed();
    }

    public List<Medico> getMedicos() { return medicos; }
    public List<Receta> getRecetas() { return recetas; }
    public List<Paciente> getPacientes() { return pacientes; }
    public List<Medicamento> getMedicamentos() { return medicamentos; }

    // --- Carga de datos de prueba ---
    private void seed() {
        // 0) Médicos (ajusta el constructor si tu clase Medico usa otra firma)
        Medico me1 = new Medico("ME-001", "Dra. Elena Ruiz", "Clínica General", "123");
        Medico me2 = new Medico("ME-002", "Dr. Pablo Soto", "Medicina Interna", "123");
        Medico me3 = new Medico("ME-003", "Dra. Karla Méndez", "Pediatría", "123");
        medicos.addAll(Arrays.asList(me1, me2, me3));

        // 1) Pacientes
        Paciente pa1 = new Paciente("P-001", "María López",   "8888-1111", LocalDate.of(1998, 3, 12));
        Paciente pa2 = new Paciente("P-002", "Carlos Gómez",  "8888-2222", LocalDate.of(1987, 7, 25));
        Paciente pa3 = new Paciente("P-003", "Ana Rodríguez", "8888-3333", LocalDate.of(2001, 1,  5));
        Paciente pa4 = new Paciente("P-004", "Luis Martínez", "8888-4444", LocalDate.of(1995, 11, 9));
        Paciente pa5 = new Paciente("P-005", "Sofía Vargas",  "8888-5555", LocalDate.of(2003, 5,  18));

        pacientes.addAll(Arrays.asList(pa1, pa2, pa3, pa4, pa5));

        // 2) Medicamentos
        Medicamento m1 = new Medicamento("M-001", "Paracetamol",  "500 mg tabletas");
        Medicamento m2 = new Medicamento("M-002", "Ibuprofeno",   "400 mg tabletas");
        Medicamento m3 = new Medicamento("M-003", "Amoxicilina",  "500 mg cápsulas");
        Medicamento m4 = new Medicamento("M-004", "Omeprazol",    "20 mg cápsulas");
        Medicamento m5 = new Medicamento("M-005", "Loratadina",   "10 mg tabletas");
        Medicamento m6 = new Medicamento("M-006", "Salbutamol",   "Inhalador 100 mcg");
        Medicamento m7 = new Medicamento("M-007", "Vitamina C",   "1 g efervescente");

        // 3) Recetas + Prescripciones (todas con médico asignado)
        // --- Receta 1: María López (Dra. Ruiz)
        Receta r1 = new Receta();
        r1.setFechaDeRetiro(LocalDate.now().minusDays(1));
        r1.setPaciente(pa1);
        r1.setMedico(me1);

        Prescripcion p1_1 = new Prescripcion("Tomar 1 tableta cada 8 horas después de los alimentos.", 5, m1, 15);
        Prescripcion p1_2 = new Prescripcion("Tomar 1 cápsula en ayunas.", 7, m4, 7);
        r1.agregarPrescripcion(p1_1);
        r1.agregarPrescripcion(p1_2);

        // --- Receta 2: Carlos Gómez (Dr. Soto)
        Receta r2 = new Receta();
        r2.setFechaDeRetiro(LocalDate.now());
        r2.setPaciente(pa2);
        r2.setMedico(me2);

        Prescripcion p2_1 = new Prescripcion("Tomar 1 tableta cada 12 horas si hay dolor.", 10, m2, 20);
        r2.agregarPrescripcion(p2_1);

        // --- Receta 3: Ana Rodríguez (Dra. Méndez)
        Receta r3 = new Receta();
        r3.setFechaDeRetiro(LocalDate.now().minusDays(3));
        r3.setPaciente(pa3);
        r3.setMedico(me3);

        Prescripcion p3_1 = new Prescripcion("Tomar 1 cápsula cada 8 horas por 7 días.", 7, m3, 21);
        Prescripcion p3_2 = new Prescripcion("Tomar 1 tableta al día.", 10, m5, 10);
        r3.agregarPrescripcion(p3_1);
        r3.agregarPrescripcion(p3_2);

        // --- Receta 4: Luis Martínez (Dr. Soto)
        Receta r4 = new Receta();
        r4.setFechaDeRetiro(LocalDate.now().plusDays(1));
        r4.setPaciente(pa4);
        r4.setMedico(me2);

        Prescripcion p4_1 = new Prescripcion("2 inhalaciones cada 6 horas según necesidad.", 14, m6, 1);
        r4.agregarPrescripcion(p4_1);

        // --- Receta 5: Sofía Vargas (Dra. Ruiz)
        Receta r5 = new Receta();
        r5.setFechaDeRetiro(LocalDate.now().plusDays(2));
        r5.setPaciente(pa5);
        r5.setMedico(me1);

        Prescripcion p5_1 = new Prescripcion("Disolver 1 tableta en agua y tomar una vez al día.", 15, m7, 15);
        Prescripcion p5_2 = new Prescripcion("Tomar 1 tableta cada 8 horas por dolor o fiebre.", 3, m1, 9);
        r5.agregarPrescripcion(p5_1);
        r5.agregarPrescripcion(p5_2);

        // 4) Agregar recetas a la lista
        recetas.add(r1);
        recetas.add(r2);
        recetas.add(r3);
        recetas.add(r4);
        recetas.add(r5);
    }
}

