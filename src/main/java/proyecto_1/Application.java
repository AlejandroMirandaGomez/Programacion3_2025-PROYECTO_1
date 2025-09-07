package proyecto_1;

import proyecto_1.presentation.acercaDe.Controller_AcercaDe;
import proyecto_1.presentation.acercaDe.Model_AcercaDe;
import proyecto_1.presentation.acercaDe.View_AcercaDe;
import proyecto_1.presentation.dashboard.Controller_Dashboard;
import proyecto_1.presentation.dashboard.Model_Dashboard;
import proyecto_1.presentation.dashboard.View_Dashboard;
import proyecto_1.presentation.despacho.Controller_Despacho;
import proyecto_1.presentation.despacho.Model_Despacho;
import proyecto_1.presentation.despacho.View_Despacho;
import proyecto_1.presentation.farmaceutas.Controller_Farmaceutas;
import proyecto_1.presentation.farmaceutas.Model_Farmaceutas;
import proyecto_1.presentation.farmaceutas.View_Farmaceutas;
import proyecto_1.presentation.historico.Controller_Historico;
import proyecto_1.presentation.historico.Model_Historico;
import proyecto_1.presentation.historico.View_Historico;
import proyecto_1.presentation.login.Controller_Login;
import proyecto_1.presentation.login.Model_Login;
import proyecto_1.presentation.login.View_Login;
import proyecto_1.presentation.medicamentos.Controller_Medicamentos;
import proyecto_1.presentation.medicamentos.Model_Medicamentos;
import proyecto_1.presentation.medicamentos.View_Medicamentos;
import proyecto_1.presentation.medicos.Controller_Medicos;
import proyecto_1.presentation.medicos.Model_Medicos;
import proyecto_1.presentation.medicos.View_Medicos;
import proyecto_1.presentation.pacientes.Controller_Pacientes;
import proyecto_1.presentation.pacientes.Model_Pacientes;
import proyecto_1.presentation.pacientes.View_Pacientes;
import proyecto_1.presentation.prescribir.Controller_Prescribir;
import proyecto_1.presentation.prescribir.Model_Prescribir;
import proyecto_1.presentation.prescribir.View_Prescribir;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        // Login MVC:
        View_Login view = new View_Login();
        Model_Login model = new Model_Login();
        Controller_Login controller = new Controller_Login(view, model);
        // *************************************************************************************************************

        // AcercaDe MVC:
        View_AcercaDe view_acercaDe = new View_AcercaDe();
        Model_AcercaDe model_acercaDe = new Model_AcercaDe();
        Controller_AcercaDe controller_acercaDe = new Controller_AcercaDe(view_acercaDe, model_acercaDe);
        // *************************************************************************************************************

        //Prescribir MVC:
        View_Prescribir view_prescribir = new View_Prescribir();
        Model_Prescribir  model_prescribir = new Model_Prescribir();
        Controller_Prescribir controller_Prescribir = new Controller_Prescribir(view_prescribir, model_prescribir);
        // *************************************************************************************************************

        //Medicos MVC
        View_Medicos view_medicos = new View_Medicos();
        Model_Medicos model_medicos = new Model_Medicos();
        Controller_Medicos controller_medicos = new Controller_Medicos(view_medicos, model_medicos);
        // *************************************************************************************************************

        //Despacho MVC:
        View_Despacho view_despacho = new View_Despacho();
        Model_Despacho model_despacho = new Model_Despacho();
        Controller_Despacho controller_despacho = new Controller_Despacho(view_despacho, model_despacho);
        // *************************************************************************************************************

        //Farmaceutas MVC
        View_Farmaceutas view_farmaceutas = new View_Farmaceutas();
        Model_Farmaceutas model_farmaceutas = new Model_Farmaceutas();
        Controller_Farmaceutas controller_farmaceutas = new Controller_Farmaceutas(view_farmaceutas, model_farmaceutas);
        // *************************************************************************************************************

        //Pacientes MVC
        View_Pacientes view_pacientes = new View_Pacientes();
        Model_Pacientes model_pacientes = new Model_Pacientes();
        Controller_Pacientes controller_pacientes = new Controller_Pacientes(view_pacientes, model_pacientes);
        // *************************************************************************************************************

        //Medicamentos MVC
        View_Medicamentos view_medicamentos = new View_Medicamentos();
        Model_Medicamentos model_medicamentos = new Model_Medicamentos();
        Controller_Medicamentos controller_medicamentos = new Controller_Medicamentos(view_medicamentos, model_medicamentos);
        // *************************************************************************************************************

        //Historico MVC
        View_Historico view_historico = new View_Historico();
        Model_Historico model_historico = new Model_Historico();
        Controller_Historico controller_historico = new Controller_Historico(view_historico, model_historico);
        // *************************************************************************************************************

        //Dashboard MVC
        View_Dashboard view_dashboard = new View_Dashboard();
        Model_Dashboard model_dashboard = new Model_Dashboard();
        Controller_Dashboard controller_dashboard = new Controller_Dashboard(view_dashboard, model_dashboard);
        // *************************************************************************************************************

        JFrame window = new JFrame();
        JTabbedPane tabbedPane = new JTabbedPane();

        window.setSize(1380,720);
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("ALL TABS");
        window.setContentPane(tabbedPane);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        window.setIconImage(new ImageIcon(Application.class.getResource("/Icons/hospital.png")).getImage());
        //tabbedPane.addTab("Login", view.getPanel());

        tabbedPane.addTab("Login", view.getPanel());
        tabbedPane.addTab("Medicos", view_medicos.getPanel());
        tabbedPane.addTab("Prescribir", view_prescribir.getPanel());
        tabbedPane.addTab("Despacho", view_despacho.getPanel());
        tabbedPane.addTab("Farmaceutas", view_farmaceutas.getPanel());
        tabbedPane.addTab("Acerca De", view_acercaDe.getPanel());
        tabbedPane.addTab("Pacientes", view_pacientes.getPanel());
        tabbedPane.addTab("Medicamentos", view_medicamentos.getPanel());
        tabbedPane.addTab("Historico", view_historico.getPanel());
        tabbedPane.addTab("Dashboard", view_dashboard.getPanel());


    }
}