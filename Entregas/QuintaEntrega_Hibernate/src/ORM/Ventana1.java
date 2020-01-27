/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Patricia Burgos
 */
public class Ventana1 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana1
     */
    public Ventana1() throws SQLException {
        initComponents();
        
        ciudades = new ArrayList();
        table_model_ciudad = (DefaultTableModel) this.jTable_ciudad.getModel();
        ciudad_modificar = new Ciudad();
        modif_ciudad = false;
                
        this.leer_ciudades();
        this.rellenar_tabla_ciudad();
        this.desactivar_botones_gc_ciudad();
        this.editable_no_ciudad();
        
        bibliotecas = new ArrayList();
        table_model_biblioteca = (DefaultTableModel) this.jTable_biblioteca.getModel();
        biblioteca_modificar = new Biblioteca();
        modif_biblioteca = false;
        
        this.leer_bibliotecas();
        this.rellenar_tabla_biblioteca();
        this.desactivar_botones_gc_biblioteca();
        this.editable_no_biblioteca();
        this.jComboBox_biblioteca.removeAllItems();
        
        libros = new ArrayList();
        table_model_libro = (DefaultTableModel) this.jTable_libro.getModel();
        libro_modificar = new Libro();
        modif_libro = false;
        
        this.leer_libro();
        this.rellenar_tabla_libro();
        this.desactivar_botones_gc_libro();
        this.editable_no_libro();
        this.jComboBox_libro.removeAllItems();
        
        personas = new ArrayList();
        table_model_persona = (DefaultTableModel) this.jTable_persona.getModel();
        persona_modificar = new Persona();
        modif_persona = false;
        
        this.leer_personas();
        this.rellenar_tabla_persona();
        this.desactivar_botones_gc_persona();
        this.editable_no_persona();
        this.jComboBox_persona.removeAllItems();
        
    }
    
   
    public void rellenar_tabla_ciudad(){
        if(table_model_ciudad.getRowCount()!=0){
            int num = table_model_ciudad.getRowCount();
            for(int i = 0; i<num; i++){
                table_model_ciudad.removeRow(i);
                i--;
                num--;
            }
        }
        for (int i = 0; i<ciudades.size(); i++){
            table_model_ciudad.addRow(new Object[]{ciudades.get(i).getNombre(),ciudades.get(i).getPais()});
        }
    }
    
    public void editable_si_ciudad(){
        this.jTextField_nombre_ciudad.setEditable(true);
        this.jTextField_pais.setEditable(true);
        this.jTextField_num_habitantes.setEditable(true);
    }
    
    public void editable_no_ciudad() {
        this.jTextField_nombre_ciudad.setEditable(false);
        this.jTextField_pais.setEditable(false);
        this.jTextField_num_habitantes.setEditable(false);
    }
    
    public void vaciar_campos_detallados_ciudad() {
        this.jTextField_nombre_ciudad.setText("");
        this.jTextField_pais.setText("");
        this.jTextField_num_habitantes.setText("");
    }
    
    public void rellenar_campos_detallados_ciudad(){
        int row = 0;
        row = this.jTable_ciudad.getSelectedRow();
        
        this.jTextField_nombre_ciudad.setText(ciudades.get(row).getNombre()); 
        this.jTextField_pais.setText(ciudades.get(row).getPais());
        this.jTextField_num_habitantes.setText(String.valueOf(ciudades.get(row).getNumHabitantes()));
    }
    
    public void vaciar_ciudad_modificar() {
        this.ciudad_modificar.setIdCiudad(0);
        this.ciudad_modificar.setNombre("");
        this.ciudad_modificar.setPais("");
        this.ciudad_modificar.setNumHabitantes(0);
    }
    
    public void rellenar_ciudad_modificar(){
        int row = 0;
        row = this.jTable_ciudad.getSelectedRow();
        
        this.ciudad_modificar.setIdCiudad(ciudades.get(row).getIdCiudad());
        this.ciudad_modificar.setNombre(ciudades.get(row).getNombre());
        this.ciudad_modificar.setPais(ciudades.get(row).getPais());
        this.ciudad_modificar.setNumHabitantes(ciudades.get(row).getNumHabitantes());
    }
    
    public void desactivar_botones_amb_ciudad(){
        this.jButton_aniadir_ciudad.setEnabled(false);
        this.jButton_modificar_ciudad.setEnabled(false);
        this.jButton_borrar_ciudad.setEnabled(false);
        this.jTable_ciudad.setEnabled(false);
    }
    
    public void activar_botones_amb_ciudad() {
        this.jButton_aniadir_ciudad.setEnabled(true);
        this.jButton_modificar_ciudad.setEnabled(true);
        this.jButton_borrar_ciudad.setEnabled(true);
        this.jTable_ciudad.setEnabled(true);
    }
    
    public void desactivar_botones_gc_ciudad(){
        this.jButton_guardar_ciudad.setEnabled(false);
        this.jButton_cancelar_ciudad.setEnabled(false);
    }
    
    public void activar_botones_gc_ciudad() {
        this.jButton_guardar_ciudad.setEnabled(true);
        this.jButton_cancelar_ciudad.setEnabled(true);
    }
    
    
    public void rellenar_tabla_biblioteca(){
        if(table_model_biblioteca.getRowCount()!=0){
            int num = table_model_biblioteca.getRowCount();
            for(int i = 0; i<num; i++){
                table_model_biblioteca.removeRow(i);
                i--;
                num--;
            }
        }
        for (int i = 0; i<bibliotecas.size(); i++){
            table_model_biblioteca.addRow(new Object[]{bibliotecas.get(i).getNombre(),bibliotecas.get(i).getTelefono()});
        }
    }
    
    public void editable_si_biblioteca(){
        this.jTextField_nombre_biblioteca.setEditable(true);
        this.jTextField_telefono.setEditable(true);
        this.jTextField_direccion.setEditable(true);
        this.jComboBox_biblioteca.setEnabled(true);
    }
    
    public void editable_no_biblioteca() {
        this.jTextField_nombre_biblioteca.setEditable(false);
        this.jTextField_telefono.setEditable(false);
        this.jTextField_direccion.setEditable(false);
        this.jComboBox_biblioteca.setEnabled(false);
    }
    
    public void vaciar_campos_detallados_biblioteca() {
        this.jTextField_nombre_biblioteca.setText("");
        this.jTextField_telefono.setText("");
        this.jTextField_direccion.setText("");
        this.jComboBox_biblioteca.removeAll();        
    }
    
    public void rellenar_campos_detallados_biblioteca(){
        int row = 0;
        row = this.jTable_biblioteca.getSelectedRow();
        
        this.jTextField_nombre_biblioteca.setText(bibliotecas.get(row).getNombre()); 
        this.jTextField_telefono.setText(bibliotecas.get(row).getTelefono());
        this.jTextField_direccion.setText(bibliotecas.get(row).getDireccion());
        this.rellenar_un_combo_biblioteca(bibliotecas.get(row).getIdCiudad());
    }
    
    public void vaciar_biblioteca_modificar() {
        this.biblioteca_modificar.setIdBiblioteca(0);
        this.biblioteca_modificar.setNombre("");
        this.biblioteca_modificar.setTelefono("");
        this.biblioteca_modificar.setDireccion("");
        this.biblioteca_modificar.setIdCiudad(0);
    }
    
    public void rellenar_biblioteca_modificar(){
        int row = 0;
        row = this.jTable_biblioteca.getSelectedRow();
        
        this.biblioteca_modificar.setIdBiblioteca(bibliotecas.get(row).getIdBiblioteca());
        this.biblioteca_modificar.setNombre(bibliotecas.get(row).getNombre());
        this.biblioteca_modificar.setTelefono(bibliotecas.get(row).getTelefono());
        this.biblioteca_modificar.setDireccion(bibliotecas.get(row).getDireccion());
        this.biblioteca_modificar.setIdCiudad(bibliotecas.get(row).getIdCiudad());
    }
    
    public void desactivar_botones_amb_biblioteca(){
        this.jButton_aniadir_biblioteca.setEnabled(false);
        this.jButton_modificar_biblioteca.setEnabled(false);
        this.jButton_borrar_biblioteca.setEnabled(false);
        this.jTable_biblioteca.setEnabled(false);
    }
    
    public void activar_botones_amb_biblioteca() {
        this.jButton_aniadir_biblioteca.setEnabled(true);
        this.jButton_modificar_biblioteca.setEnabled(true);
        this.jButton_borrar_biblioteca.setEnabled(true);
        this.jTable_biblioteca.setEnabled(true);
    }
    
    public void desactivar_botones_gc_biblioteca(){
        this.jButton_guardar_biblioteca.setEnabled(false);
        this.jButton_cancelar_biblioteca.setEnabled(false);
        this.jComboBox_biblioteca.setEnabled(false);
    }
    
    public void activar_botones_gc_biblioteca() {
        this.jButton_guardar_biblioteca.setEnabled(true);
        this.jButton_cancelar_biblioteca.setEnabled(true);
        this.jComboBox_biblioteca.setEnabled(true);        
    }
    
    public void rellenar_todo_combo_biblioteca(){
        this.jComboBox_biblioteca.removeAllItems();
        for(int i = 0; i<ciudades.size();i++){
            this.jComboBox_biblioteca.addItem(this.ciudades.get(i).getNombre());
        }
    }
    public void rellenar_un_combo_biblioteca(int pos){
        this.jComboBox_biblioteca.removeAllItems();
        for (int i = 0; i<this.ciudades.size();i++){
            if(pos==ciudades.get(i).getIdCiudad()){
                this.jComboBox_biblioteca.addItem(ciudades.get(i).getNombre());
            }
        }        
    }
    
    public void poner_id_biblioteca(Biblioteca nueva){
        //PORHACER CAMBIAR TODOS ESTOS METODOS
        String combox = this.jComboBox_biblioteca.getSelectedItem().toString();
        System.out.println("COMBOX= " + combox);
        
        for (int i = 0; i<this.ciudades.size();i++){
            if(combox == ciudades.get(i).getNombre()){
                nueva.setIdCiudad(ciudades.get(i).getIdCiudad());
            }
        } 
    }
    
    public boolean busqueda_id_ciudad_en_biblioteca(boolean borrar, int pos){
        int id = ciudades.get(pos).getIdCiudad();
        for(int i = 0; i<this.bibliotecas.size();i++){
            if(bibliotecas.get(i).getIdCiudad() == id){
                borrar = false;
            }
        }
        return borrar;
    }
    
        
    public void rellenar_tabla_libro(){
        if(table_model_libro.getRowCount()!=0){
            int num = table_model_libro.getRowCount();
            for(int i = 0; i<num; i++){
                table_model_libro.removeRow(i);
                i--;
                num--;
            }
        }
        for (int i = 0; i<libros.size(); i++){
            table_model_libro.addRow(new Object[]{libros.get(i).getTitulo(),libros.get(i).getAutor()});
        }
    }
    
    public void editable_si_libro(){
        this.jTextField_nombre_libro.setEditable(true);
        this.jTextField_autor.setEditable(true);
        this.jTextField_edad_recomendada.setEditable(true);
        this.jTextField_anio_publicacion.setEditable(true);
        this.jComboBox_libro.setEnabled(true);
    }
    
    public void editable_no_libro() {
        this.jTextField_nombre_libro.setEditable(false);
        this.jTextField_autor.setEditable(false);
        this.jTextField_edad_recomendada.setEditable(false);
        this.jTextField_anio_publicacion.setEditable(false);
        this.jComboBox_libro.setEnabled(false);
    }
    
    public void vaciar_campos_detallados_libro() {
        this.jTextField_nombre_libro.setText("");
        this.jTextField_autor.setText("");
        this.jTextField_edad_recomendada.setText("");
        this.jTextField_anio_publicacion.setText("");
        this.jComboBox_libro.removeAll();        
    }
    
    public void rellenar_campos_detallados_libro(){
        int row = 0;
        row = this.jTable_libro.getSelectedRow();
        
        this.jTextField_nombre_libro.setText(libros.get(row).getTitulo()); 
        this.jTextField_autor.setText(libros.get(row).getAutor());
        this.jTextField_edad_recomendada.setText(String.valueOf(libros.get(row).getEdadRecomendada()));
        this.jTextField_anio_publicacion.setText(String.valueOf(libros.get(row).getAnioPublicacion()));        
        this.rellenar_un_combo_libro(libros.get(row).getIdBiblioteca());
    }
    
    public void vaciar_libro_modificar() {
        this.libro_modificar.setIdLibro(0);
        this.libro_modificar.setTitulo("");
        this.libro_modificar.setAutor("");
        this.libro_modificar.setEdadRecomendada(0);
        this.libro_modificar.setAnioPublicacion(0);
        this.libro_modificar.setIdBiblioteca(0);
    }
    
    public void rellenar_libro_modificar(){
        int row = 0;
        row = this.jTable_libro.getSelectedRow();
        
        this.libro_modificar.setIdLibro(libros.get(row).getIdLibro());
        this.libro_modificar.setTitulo(libros.get(row).getTitulo());
        this.libro_modificar.setAutor(libros.get(row).getAutor());
        this.libro_modificar.setEdadRecomendada(libros.get(row).getEdadRecomendada());        
        this.libro_modificar.setAnioPublicacion(libros.get(row).getAnioPublicacion());
        this.libro_modificar.setIdBiblioteca(libros.get(row).getIdBiblioteca());
    }
    
    public void desactivar_botones_amb_libro(){
        this.jButton_aniadir_libro.setEnabled(false);
        this.jButton_modificar_libro.setEnabled(false);
        this.jButton_borrar_libro.setEnabled(false);
        this.jTable_libro.setEnabled(false);
    }
    
    public void activar_botones_amb_libro() {
        this.jButton_aniadir_libro.setEnabled(true);
        this.jButton_modificar_libro.setEnabled(true);
        this.jButton_borrar_libro.setEnabled(true);
        this.jTable_libro.setEnabled(true);
    }
    
    public void desactivar_botones_gc_libro(){
        this.jButton_guardar_libro.setEnabled(false);
        this.jButton_cancelar_libro.setEnabled(false);
        this.jComboBox_libro.setEnabled(false);
    }
    
    public void activar_botones_gc_libro() {
        this.jButton_guardar_libro.setEnabled(true);
        this.jButton_cancelar_libro.setEnabled(true);
        this.jComboBox_libro.setEnabled(true);        
    }
    
    public void rellenar_todo_combo_libro(){
        this.jComboBox_libro.removeAllItems();
        for(int i = 0; i<bibliotecas.size();i++){
            this.jComboBox_libro.addItem(this.bibliotecas.get(i).getNombre());
        }
    }
    public void rellenar_un_combo_libro(int pos){
        this.jComboBox_libro.removeAllItems();
        for (int i = 0; i<this.bibliotecas.size();i++){
            //TODO ¡¡¡ Si no pongo los id no me los coge
            System.out.println("pos " + pos);
            System.out.println("getId" + bibliotecas.get(i).getIdBiblioteca());
            if(pos==bibliotecas.get(i).getIdBiblioteca()){
                this.jComboBox_libro.addItem(bibliotecas.get(i).getNombre());
            }
        }          
    }
    
    public void poner_id_libro(Libro nueva){
        String combox = this.jComboBox_libro.getSelectedItem().toString();
        System.out.println("COMBOX= " + combox);
        
        for (int i = 0; i<this.bibliotecas.size();i++){
            if(combox == bibliotecas.get(i).getNombre()){
                nueva.setIdBiblioteca(bibliotecas.get(i).getIdBiblioteca());
            }
        } 
    }
    
    public boolean busqueda_id_biblioteca_en_libro(boolean borrar, int pos){
        int id = bibliotecas.get(pos).getIdBiblioteca();
        for(int i = 0; i<this.libros.size() && borrar;i++){
            if(libros.get(i).getIdBiblioteca() == id){
                borrar = false;
            }
        }
        return borrar;
    }
    public boolean busqueda_id_libro_en_persona(boolean borrar, int pos){
        int id = libros.get(pos).getIdLibro();
        for(int i = 0; i<this.personas.size() && borrar;i++){
            if(personas.get(i).getIdLibro() == id){
                borrar = false;
            }
        }
        return borrar;
    }
    
    
    public void rellenar_tabla_persona(){
        if(table_model_persona.getRowCount()!=0){
            int num = table_model_persona.getRowCount();
            for(int i = 0; i<num; i++){
                table_model_persona.removeRow(i);
                i--;
                num--;
            }
        }
        for (int i = 0; i<personas.size(); i++){
            table_model_persona.addRow(new Object[]{personas.get(i).getNombre(),personas.get(i).getDni()});
        }
    }
    
    public void editable_si_persona(){
        this.jTextField_nombre_persona.setEditable(true);
        this.jTextField_DNI.setEditable(true);
        this.jTextField_edad_persona.setEditable(true);
        this.jTextField_ciudad_natal.setEditable(true);
        this.jComboBox_persona.setEnabled(true);
    }
    
    public void editable_no_persona() {
        this.jTextField_nombre_persona.setEditable(false);
        this.jTextField_DNI.setEditable(false);
        this.jTextField_edad_persona.setEditable(false);
        this.jTextField_ciudad_natal.setEditable(false);
        this.jComboBox_persona.setEnabled(false);
    }
    
    public void vaciar_campos_detallados_persona() {
        this.jTextField_nombre_persona.setText("");
        this.jTextField_DNI.setText("");
        this.jTextField_edad_persona.setText("");
        this.jTextField_ciudad_natal.setText("");
        this.jComboBox_persona.removeAll();        
    }
    
    public void rellenar_campos_detallados_persona(){
        int row = 0;
        row = this.jTable_persona.getSelectedRow();
        
        this.jTextField_nombre_persona.setText(personas.get(row).getNombre()); 
        this.jTextField_DNI.setText(personas.get(row).getDni());
        this.jTextField_edad_persona.setText(personas.get(row).getEdad());
        this.jTextField_ciudad_natal.setText(personas.get(row).getCiudadNatal());        
        this.rellenar_un_combo_persona(personas.get(row).getIdLibro());
    }
    
    public void vaciar_persona_modificar() {
        this.persona_modificar.setIdPersona(0);
        this.persona_modificar.setNombre("");
        this.persona_modificar.setDni("");
        this.persona_modificar.setEdad("");
        this.persona_modificar.setCiudadNatal("");
        this.persona_modificar.setIdLibro(0);
    }
    
    public void rellenar_persona_modificar(){
        int row = 0;
        row = this.jTable_persona.getSelectedRow();
        
        this.persona_modificar.setIdPersona(personas.get(row).getIdPersona());
        this.persona_modificar.setNombre(personas.get(row).getNombre());
        this.persona_modificar.setDni(personas.get(row).getDni());
        this.persona_modificar.setEdad(personas.get(row).getEdad());        
        this.persona_modificar.setCiudadNatal(personas.get(row).getCiudadNatal());
        this.persona_modificar.setIdLibro(personas.get(row).getIdLibro());
    }
    
    public void desactivar_botones_amb_persona(){
        this.jButton_aniadir_persona.setEnabled(false);
        this.jButton_modificar_persona.setEnabled(false);
        this.jButton_borrar_persona.setEnabled(false);
        this.jTable_persona.setEnabled(false);
    }
    
    public void activar_botones_amb_persona() {
        this.jButton_aniadir_persona.setEnabled(true);
        this.jButton_modificar_persona.setEnabled(true);
        this.jButton_borrar_persona.setEnabled(true);
        this.jTable_persona.setEnabled(true);
    }
    
    public void desactivar_botones_gc_persona(){
        this.jButton_guardar_persona.setEnabled(false);
        this.jButton_cancelar_persona.setEnabled(false);
        this.jComboBox_persona.setEnabled(false);
    }
    
    public void activar_botones_gc_persona() {
        this.jButton_guardar_persona.setEnabled(true);
        this.jButton_cancelar_persona.setEnabled(true);
        this.jComboBox_persona.setEnabled(true);        
    }
    
    public void rellenar_todo_combo_persona(){
        this.jComboBox_persona.removeAllItems();
        for(int i = 0; i<libros.size();i++){
            this.jComboBox_persona.addItem(this.libros.get(i).getTitulo());
        }
    }
    public void rellenar_un_combo_persona(int pos){
        this.jComboBox_persona.removeAllItems();
        for (int i = 0; i<this.libros.size();i++){
            if(pos==libros.get(i).getIdLibro()){
                this.jComboBox_persona.addItem(libros.get(i).getTitulo());
            }
        }          
    }
    
    public void poner_id_persona(Persona nueva){
        String combox = this.jComboBox_persona.getSelectedItem().toString();
        System.out.println("COMBOX= " + combox);
        
        for (int i = 0; i<this.libros.size();i++){
            if(combox == libros.get(i).getTitulo()){
                nueva.setIdLibro(libros.get(i).getIdLibro());
            }
        } 
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel_ciudad = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ciudad = new javax.swing.JTable();
        jButton_aniadir_ciudad = new javax.swing.JButton();
        jButton_modificar_ciudad = new javax.swing.JButton();
        jButton_borrar_ciudad = new javax.swing.JButton();
        jLabel_nombre_ciudad = new javax.swing.JLabel();
        jLabel_pais = new javax.swing.JLabel();
        jLabel_num_habitantes = new javax.swing.JLabel();
        jTextField_nombre_ciudad = new javax.swing.JTextField();
        jTextField_pais = new javax.swing.JTextField();
        jTextField_num_habitantes = new javax.swing.JTextField();
        jButton_guardar_ciudad = new javax.swing.JButton();
        jButton_cancelar_ciudad = new javax.swing.JButton();
        jPanel_biblioteca = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_biblioteca = new javax.swing.JTable();
        jLabel_nombre_biblioteca = new javax.swing.JLabel();
        jLabel_telefono = new javax.swing.JLabel();
        jLabel_direccion = new javax.swing.JLabel();
        jTextField_nombre_biblioteca = new javax.swing.JTextField();
        jTextField_telefono = new javax.swing.JTextField();
        jTextField_direccion = new javax.swing.JTextField();
        jButton_guardar_biblioteca = new javax.swing.JButton();
        jButton_cancelar_biblioteca = new javax.swing.JButton();
        jButton_aniadir_biblioteca = new javax.swing.JButton();
        jButton_modificar_biblioteca = new javax.swing.JButton();
        jButton_borrar_biblioteca = new javax.swing.JButton();
        jComboBox_biblioteca = new javax.swing.JComboBox<>();
        jLabel_ciudades_bibliotecas = new javax.swing.JLabel();
        jPanel_libro = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_libro = new javax.swing.JTable();
        jLabel_nombre_libro = new javax.swing.JLabel();
        jLabel_autor = new javax.swing.JLabel();
        jLabel_edad_recomendada = new javax.swing.JLabel();
        jLabel_biblioteca_libro = new javax.swing.JLabel();
        jComboBox_libro = new javax.swing.JComboBox<>();
        jTextField_edad_recomendada = new javax.swing.JTextField();
        jTextField_nombre_libro = new javax.swing.JTextField();
        jTextField_autor = new javax.swing.JTextField();
        jButton_guardar_libro = new javax.swing.JButton();
        jButton_cancelar_libro = new javax.swing.JButton();
        jButton_borrar_libro = new javax.swing.JButton();
        jButton_modificar_libro = new javax.swing.JButton();
        jButton_aniadir_libro = new javax.swing.JButton();
        jLabel_anio_publicacion = new javax.swing.JLabel();
        jTextField_anio_publicacion = new javax.swing.JTextField();
        jPanel_persona = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_persona = new javax.swing.JTable();
        jLabel_nombre_persona = new javax.swing.JLabel();
        jLabel_DNI = new javax.swing.JLabel();
        jLabel_edad_persona = new javax.swing.JLabel();
        jLabel_libro_persona = new javax.swing.JLabel();
        jComboBox_persona = new javax.swing.JComboBox<>();
        jTextField_edad_persona = new javax.swing.JTextField();
        jTextField_nombre_persona = new javax.swing.JTextField();
        jTextField_DNI = new javax.swing.JTextField();
        jButton_guardar_persona = new javax.swing.JButton();
        jButton_cancelar_persona = new javax.swing.JButton();
        jButton_borrar_persona = new javax.swing.JButton();
        jButton_modificar_persona = new javax.swing.JButton();
        jButton_aniadir_persona = new javax.swing.JButton();
        jLabel_ciudad_natal = new javax.swing.JLabel();
        jTextField_ciudad_natal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable_ciudad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Pais"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ciudadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_ciudad);
        if (jTable_ciudad.getColumnModel().getColumnCount() > 0) {
            jTable_ciudad.getColumnModel().getColumn(0).setResizable(false);
            jTable_ciudad.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton_aniadir_ciudad.setText("Añadir");
        jButton_aniadir_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_ciudadActionPerformed(evt);
            }
        });

        jButton_modificar_ciudad.setText("Modificar");
        jButton_modificar_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_ciudadActionPerformed(evt);
            }
        });

        jButton_borrar_ciudad.setText("Borrar");
        jButton_borrar_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_ciudadActionPerformed(evt);
            }
        });

        jLabel_nombre_ciudad.setText("Nombre:");

        jLabel_pais.setText("Pais:");

        jLabel_num_habitantes.setText("Nº Habitantes:");

        jTextField_nombre_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombre_ciudadActionPerformed(evt);
            }
        });

        jButton_guardar_ciudad.setText("Guardar");
        jButton_guardar_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_ciudadActionPerformed(evt);
            }
        });

        jButton_cancelar_ciudad.setText("Cancelar");
        jButton_cancelar_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_ciudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ciudadLayout = new javax.swing.GroupLayout(jPanel_ciudad);
        jPanel_ciudad.setLayout(jPanel_ciudadLayout);
        jPanel_ciudadLayout.setHorizontalGroup(
            jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_nombre_ciudad)
                            .addComponent(jLabel_pais)
                            .addComponent(jLabel_num_habitantes))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_nombre_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jTextField_pais)
                            .addComponent(jTextField_num_habitantes))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_guardar_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_cancelar_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_ciudadLayout.setVerticalGroup(
            jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_ciudad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_ciudad))
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nombre_ciudad)
                    .addComponent(jTextField_nombre_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pais)
                    .addComponent(jTextField_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar_ciudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_num_habitantes)
                    .addComponent(jTextField_num_habitantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar_ciudad))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Ciudad", jPanel_ciudad);

        jTable_biblioteca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_biblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_bibliotecaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_biblioteca);
        if (jTable_biblioteca.getColumnModel().getColumnCount() > 0) {
            jTable_biblioteca.getColumnModel().getColumn(0).setResizable(false);
            jTable_biblioteca.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel_nombre_biblioteca.setText("Nombre:");

        jLabel_telefono.setText("Telefono:");

        jLabel_direccion.setText("Direccion");

        jTextField_nombre_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombre_bibliotecaActionPerformed(evt);
            }
        });

        jButton_guardar_biblioteca.setText("Guardar");
        jButton_guardar_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_bibliotecaActionPerformed(evt);
            }
        });

        jButton_cancelar_biblioteca.setText("Cancelar");
        jButton_cancelar_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_bibliotecaActionPerformed(evt);
            }
        });

        jButton_aniadir_biblioteca.setText("Añadir");
        jButton_aniadir_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_bibliotecaActionPerformed(evt);
            }
        });

        jButton_modificar_biblioteca.setText("Modificar");
        jButton_modificar_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_bibliotecaActionPerformed(evt);
            }
        });

        jButton_borrar_biblioteca.setText("Borrar");
        jButton_borrar_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_bibliotecaActionPerformed(evt);
            }
        });

        jComboBox_biblioteca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_bibliotecaActionPerformed(evt);
            }
        });

        jLabel_ciudades_bibliotecas.setText("Ciudad:");

        javax.swing.GroupLayout jPanel_bibliotecaLayout = new javax.swing.GroupLayout(jPanel_biblioteca);
        jPanel_biblioteca.setLayout(jPanel_bibliotecaLayout);
        jPanel_bibliotecaLayout.setHorizontalGroup(
            jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_nombre_biblioteca)
                            .addComponent(jLabel_telefono)
                            .addComponent(jLabel_direccion)
                            .addComponent(jLabel_ciudades_bibliotecas))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_nombre_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(jTextField_telefono)
                                    .addComponent(jTextField_direccion))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_guardar_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_cancelar_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_bibliotecaLayout.setVerticalGroup(
            jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_biblioteca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_biblioteca))
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nombre_biblioteca)
                    .addComponent(jTextField_nombre_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_telefono)
                    .addComponent(jTextField_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar_biblioteca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_direccion)
                    .addComponent(jTextField_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar_biblioteca))
                .addGap(18, 18, 18)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ciudades_bibliotecas)
                    .addComponent(jComboBox_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Biblioteca", jPanel_biblioteca);

        jTable_libro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_libro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_libroMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_libro);
        if (jTable_libro.getColumnModel().getColumnCount() > 0) {
            jTable_libro.getColumnModel().getColumn(0).setResizable(false);
            jTable_libro.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel_nombre_libro.setText("Titulo:");

        jLabel_autor.setText("Autor:");

        jLabel_edad_recomendada.setText("Edad Rec:");

        jLabel_biblioteca_libro.setText("Biblioteca:");

        jComboBox_libro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_libroActionPerformed(evt);
            }
        });

        jTextField_nombre_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombre_libroActionPerformed(evt);
            }
        });

        jButton_guardar_libro.setText("Guardar");
        jButton_guardar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_libroActionPerformed(evt);
            }
        });

        jButton_cancelar_libro.setText("Cancelar");
        jButton_cancelar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_libroActionPerformed(evt);
            }
        });

        jButton_borrar_libro.setText("Borrar");
        jButton_borrar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_libroActionPerformed(evt);
            }
        });

        jButton_modificar_libro.setText("Modificar");
        jButton_modificar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_libroActionPerformed(evt);
            }
        });

        jButton_aniadir_libro.setText("Añadir");
        jButton_aniadir_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_libroActionPerformed(evt);
            }
        });

        jLabel_anio_publicacion.setText("Año Public:");

        javax.swing.GroupLayout jPanel_libroLayout = new javax.swing.GroupLayout(jPanel_libro);
        jPanel_libro.setLayout(jPanel_libroLayout);
        jPanel_libroLayout.setHorizontalGroup(
            jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libroLayout.createSequentialGroup()
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_libro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_libro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_libro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_nombre_libro)
                            .addComponent(jLabel_autor)
                            .addComponent(jLabel_edad_recomendada)
                            .addComponent(jLabel_biblioteca_libro)
                            .addComponent(jLabel_anio_publicacion))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_libroLayout.createSequentialGroup()
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField_anio_publicacion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_nombre_libro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(jTextField_autor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_edad_recomendada, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_guardar_libro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_cancelar_libro, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_libroLayout.setVerticalGroup(
            jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libroLayout.createSequentialGroup()
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_libro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_libro))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nombre_libro)
                    .addComponent(jTextField_nombre_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_autor)
                    .addComponent(jTextField_autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar_libro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_edad_recomendada)
                    .addComponent(jTextField_edad_recomendada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar_libro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_anio_publicacion)
                    .addComponent(jTextField_anio_publicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_biblioteca_libro)
                    .addComponent(jComboBox_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Libro", jPanel_libro);

        jTable_persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "DNI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_persona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_personaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_persona);
        if (jTable_persona.getColumnModel().getColumnCount() > 0) {
            jTable_persona.getColumnModel().getColumn(0).setResizable(false);
            jTable_persona.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel_nombre_persona.setText("Nombre:");

        jLabel_DNI.setText("DNI:");

        jLabel_edad_persona.setText("Edad:");

        jLabel_libro_persona.setText("Libro:");

        jComboBox_persona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_personaActionPerformed(evt);
            }
        });

        jTextField_nombre_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombre_personaActionPerformed(evt);
            }
        });

        jButton_guardar_persona.setText("Guardar");
        jButton_guardar_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_personaActionPerformed(evt);
            }
        });

        jButton_cancelar_persona.setText("Cancelar");
        jButton_cancelar_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_personaActionPerformed(evt);
            }
        });

        jButton_borrar_persona.setText("Borrar");
        jButton_borrar_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_personaActionPerformed(evt);
            }
        });

        jButton_modificar_persona.setText("Modificar");
        jButton_modificar_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_personaActionPerformed(evt);
            }
        });

        jButton_aniadir_persona.setText("Añadir");
        jButton_aniadir_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_personaActionPerformed(evt);
            }
        });

        jLabel_ciudad_natal.setText("Ciudad:");

        javax.swing.GroupLayout jPanel_personaLayout = new javax.swing.GroupLayout(jPanel_persona);
        jPanel_persona.setLayout(jPanel_personaLayout);
        jPanel_personaLayout.setHorizontalGroup(
            jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_personaLayout.createSequentialGroup()
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_persona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_persona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_persona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_nombre_persona)
                            .addComponent(jLabel_DNI)
                            .addComponent(jLabel_edad_persona)
                            .addComponent(jLabel_libro_persona)
                            .addComponent(jLabel_ciudad_natal))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_personaLayout.createSequentialGroup()
                                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_nombre_persona, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(jTextField_DNI)
                                    .addComponent(jTextField_edad_persona)
                                    .addComponent(jTextField_ciudad_natal, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_guardar_persona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_cancelar_persona, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_personaLayout.setVerticalGroup(
            jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_personaLayout.createSequentialGroup()
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_persona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_persona, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_persona))
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nombre_persona)
                    .addComponent(jTextField_nombre_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_DNI)
                    .addComponent(jTextField_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar_persona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_edad_persona)
                    .addComponent(jTextField_edad_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar_persona))
                .addGap(18, 18, 18)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ciudad_natal)
                    .addComponent(jTextField_ciudad_natal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_libro_persona)
                    .addComponent(jComboBox_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Persona", jPanel_persona);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("Ciudad");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_nombre_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombre_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombre_ciudadActionPerformed

    private void jButton_cancelar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_ciudadActionPerformed
        if(modif_ciudad==true){
            Ciudad nuevo = new Ciudad(ciudad_modificar.getNombre(),ciudad_modificar.getPais(),ciudad_modificar.getNumHabitantes());
            
            ciudades.add(nuevo);
            table_model_ciudad.addRow(new Object[]{ciudades.get(this.ciudades.size()-1).getNombre(),ciudades.get(this.ciudades.size()-1).getPais()});
        
            try {
                this.insertar_una_ciudad(this.jTextField_nombre_ciudad.getText(), this.jTextField_pais.getText(), Integer.parseInt(this.jTextField_num_habitantes.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.vaciar_ciudad_modificar();         
            table_model_ciudad.fireTableDataChanged();
        }
        this.modif_ciudad=false;
        this.vaciar_campos_detallados_ciudad();
        this.editable_no_ciudad();
        this.desactivar_botones_gc_ciudad();
        this.activar_botones_amb_ciudad();
    }//GEN-LAST:event_jButton_cancelar_ciudadActionPerformed

    private void jTextField_nombre_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombre_bibliotecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombre_bibliotecaActionPerformed

    private void jButton_cancelar_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_bibliotecaActionPerformed
        if(modif_biblioteca==true){
            Biblioteca nuevo = new Biblioteca(biblioteca_modificar.getNombre(),biblioteca_modificar.getTelefono(),biblioteca_modificar.getDireccion(),this.biblioteca_modificar.getIdCiudad());
            
            bibliotecas.add(nuevo);
            table_model_biblioteca.addRow(new Object[]{bibliotecas.get(this.bibliotecas.size()-1).getNombre(),bibliotecas.get(this.bibliotecas.size()-1).getTelefono()});
        
            try {
                this.insertar_una_biblioteca(biblioteca_modificar.getNombre(),biblioteca_modificar.getTelefono(), biblioteca_modificar.getDireccion(), this.biblioteca_modificar.getIdCiudad());
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.vaciar_biblioteca_modificar();         
            table_model_biblioteca.fireTableDataChanged();
        }
        this.modif_biblioteca=false;
        this.vaciar_campos_detallados_biblioteca();
        this.editable_no_biblioteca();
        this.desactivar_botones_gc_biblioteca();
        this.activar_botones_amb_biblioteca(); 
        this.jComboBox_biblioteca.removeAllItems();
    }//GEN-LAST:event_jButton_cancelar_bibliotecaActionPerformed

    private void jComboBox_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_bibliotecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_bibliotecaActionPerformed

    private void jComboBox_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_libroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_libroActionPerformed

    private void jTextField_nombre_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombre_libroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombre_libroActionPerformed

    private void jButton_cancelar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_libroActionPerformed
        if(modif_libro==true){
            Libro nuevo = new Libro(libro_modificar.getTitulo(),libro_modificar.getAutor(),libro_modificar.getAnioPublicacion(),libro_modificar.getEdadRecomendada(),this.libro_modificar.getIdBiblioteca());
            
            libros.add(nuevo);
            table_model_libro.addRow(new Object[]{libros.get(this.libros.size()-1).getTitulo(),libros.get(this.libros.size()-1).getAutor()});
        
            try {
                this.insertar_un_libro(this.jTextField_nombre_libro.getText(), this.jTextField_autor.getText(), Integer.parseInt(this.jTextField_anio_publicacion.getText()), Integer.parseInt(this.jTextField_edad_recomendada.getText()), libros.get(libros.size()-1).getIdBiblioteca());
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            this.vaciar_libro_modificar();         
            table_model_libro.fireTableDataChanged();
        }
        this.modif_libro=false;
        this.vaciar_campos_detallados_libro();
        this.editable_no_libro();
        this.desactivar_botones_gc_libro();
        this.activar_botones_amb_libro(); 
        this.jComboBox_libro.removeAllItems();
    }//GEN-LAST:event_jButton_cancelar_libroActionPerformed

    private void jComboBox_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_personaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_personaActionPerformed

    private void jTextField_nombre_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombre_personaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombre_personaActionPerformed

    private void jButton_cancelar_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_personaActionPerformed
        if(modif_persona==true){
            Persona nuevo = new Persona(persona_modificar.getDni(),persona_modificar.getNombre(),persona_modificar.getEdad(),persona_modificar.getCiudadNatal(),this.persona_modificar.getIdLibro());
            
            personas.add(nuevo);
            table_model_persona.addRow(new Object[]{personas.get(this.personas.size()-1).getNombre(),personas.get(this.personas.size()-1).getDni()});
        
            try {
                this.insertar_una_persona(this.jTextField_DNI.getText(), this.jTextField_nombre_persona.getText(), this.jTextField_edad_persona.getText(), this.jTextField_ciudad_natal.getText(), personas.get(personas.size()-1).getIdLibro());
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            this.vaciar_persona_modificar();         
            table_model_persona.fireTableDataChanged();
        }
        this.modif_persona=false;
        this.vaciar_campos_detallados_persona();
        this.editable_no_persona();
        this.desactivar_botones_gc_persona();
        this.activar_botones_amb_persona(); 
        this.jComboBox_persona.removeAllItems();
    }//GEN-LAST:event_jButton_cancelar_personaActionPerformed

    private void jButton_modificar_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_personaActionPerformed
        row_per=this.jTable_persona.getSelectedRow();        
        this.modif_persona=true;
        
        this.editable_si_persona();
        this.rellenar_campos_detallados_persona();
        this.rellenar_todo_combo_persona();
        this.rellenar_persona_modificar();
        this.activar_botones_gc_persona();
        this.desactivar_botones_amb_persona();
    }//GEN-LAST:event_jButton_modificar_personaActionPerformed

    private void jTable_ciudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ciudadMouseClicked
        this.rellenar_campos_detallados_ciudad();
    }//GEN-LAST:event_jTable_ciudadMouseClicked

    private void jButton_borrar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_ciudadActionPerformed
        int row = 0;
        row = this.jTable_ciudad.getSelectedRow();
                
        boolean borrar = true;
        if(bibliotecas.size()!=0){
            borrar = this.busqueda_id_ciudad_en_biblioteca(borrar,row);        
        }
        if(borrar == false){
            JOptionPane.showMessageDialog(null, "No puede borrar una ciudad asignada a una biblioteca");
        }else{
            try {
                this.eliminar_una_ciudad(ciudades.get(row));
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
            table_model_ciudad.removeRow(row);
            this.ciudades.remove(row);
            table_model_ciudad.fireTableDataChanged();
            this.vaciar_campos_detallados_ciudad();
        }
    }//GEN-LAST:event_jButton_borrar_ciudadActionPerformed

    private void jButton_modificar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_ciudadActionPerformed
        row_ciu = this.jTable_ciudad.getSelectedRow();                
        this.modif_ciudad=true;
        
        this.editable_si_ciudad();
        this.rellenar_campos_detallados_ciudad();
        this.rellenar_ciudad_modificar();
        this.activar_botones_gc_ciudad();
        this.desactivar_botones_amb_ciudad();
    }//GEN-LAST:event_jButton_modificar_ciudadActionPerformed

    private void jButton_guardar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_ciudadActionPerformed
        Ciudad nueva;
        if(modif_ciudad==true){
            nueva = new Ciudad(this.jTextField_nombre_ciudad.getText(),this.jTextField_pais.getText(),Integer.parseInt(this.jTextField_num_habitantes.getText()));           
            String ciu_antiguo = ciudades.get(row_ciu).getNombre();
            ciudades.get(row_ciu).setNombre(this.jTextField_nombre_ciudad.getText());
            ciudades.get(row_ciu).setPais(this.jTextField_pais.getText());
            ciudades.get(row_ciu).setNumHabitantes(Integer.parseInt(this.jTextField_num_habitantes.getText()));
            
            nueva.setIdCiudad(ciudades.get(row_ciu).getIdCiudad());
            this.actualizar_ciudad(ciudades.get(row_ciu),ciu_antiguo);
            this.rellenar_tabla_ciudad();
            this.jTable_ciudad.setVisible(false);
            this.jTable_ciudad.setVisible(true);
        }else{
            try {
                consultar_ultimo_id_ciudad();
                id_ciu+=1;
                nueva = new Ciudad(this.jTextField_nombre_ciudad.getText(),this.jTextField_pais.getText(),Integer.parseInt(this.jTextField_num_habitantes.getText()));
                nueva.setIdCiudad(id_ciu);
                ciudades.add(nueva);
                table_model_ciudad.addRow(new Object[]{ciudades.get(this.ciudades.size()-1).getNombre(),ciudades.get(this.ciudades.size()-1).getPais()});
       
                try {
                    this.insertar_una_ciudad(this.jTextField_nombre_ciudad.getText(), this.jTextField_pais.getText(), Integer.parseInt(this.jTextField_num_habitantes.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }                                
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.vaciar_campos_detallados_ciudad();
        this.vaciar_ciudad_modificar();
        this.editable_no_ciudad();        
        this.modif_ciudad=false;
        this.desactivar_botones_gc_ciudad();
        this.activar_botones_amb_ciudad();       
    }//GEN-LAST:event_jButton_guardar_ciudadActionPerformed

    private void jTable_bibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_bibliotecaMouseClicked
        this.rellenar_campos_detallados_biblioteca();
    }//GEN-LAST:event_jTable_bibliotecaMouseClicked

    private void jButton_aniadir_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_bibliotecaActionPerformed
        this.editable_si_biblioteca();
        this.vaciar_campos_detallados_biblioteca();
        this.desactivar_botones_amb_biblioteca();
        this.activar_botones_gc_biblioteca();
        this.jTextField_nombre_biblioteca.requestFocus();
        this.rellenar_todo_combo_biblioteca();
    }//GEN-LAST:event_jButton_aniadir_bibliotecaActionPerformed

    private void jButton_aniadir_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_ciudadActionPerformed
        this.editable_si_ciudad();
        this.vaciar_campos_detallados_ciudad();
        this.desactivar_botones_amb_ciudad();
        this.activar_botones_gc_ciudad();
        this.jTextField_nombre_ciudad.requestFocus();
    }//GEN-LAST:event_jButton_aniadir_ciudadActionPerformed

    private void jButton_modificar_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_bibliotecaActionPerformed
        row_bib=this.jTable_biblioteca.getSelectedRow();;        
        this.modif_biblioteca=true;
        
        this.editable_si_biblioteca();
        this.rellenar_campos_detallados_biblioteca();
        this.rellenar_todo_combo_biblioteca();
        this.rellenar_biblioteca_modificar();        
        this.activar_botones_gc_biblioteca();
        this.desactivar_botones_amb_biblioteca();
    }//GEN-LAST:event_jButton_modificar_bibliotecaActionPerformed

    private void jButton_borrar_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_bibliotecaActionPerformed
        boolean borrar = true;
        
        int row = 0;
        row = this.jTable_biblioteca.getSelectedRow();
        if(libros.size()!=0){
            borrar = this.busqueda_id_biblioteca_en_libro(borrar,row);        
        }
        if(borrar == false){
            JOptionPane.showMessageDialog(null, "No puede borrar una biblioteca asignada a un libro");
        }else{ 
            
            try {
                this.eliminar_una_biblioteca(bibliotecas.get(row));
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
            table_model_biblioteca.removeRow(row);
            this.bibliotecas.remove(row);
            table_model_biblioteca.fireTableDataChanged();
            this.vaciar_campos_detallados_biblioteca();           
            this.jComboBox_biblioteca.removeAllItems();
        }
    }//GEN-LAST:event_jButton_borrar_bibliotecaActionPerformed

    private void jButton_guardar_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_bibliotecaActionPerformed
        Biblioteca nueva;        
        if(modif_biblioteca==true){
            nueva = new Biblioteca(this.jTextField_nombre_biblioteca.getText(),this.jTextField_telefono.getText(),this.jTextField_direccion.getText(),this.biblioteca_modificar.getIdCiudad());
            poner_id_biblioteca(nueva);
            String bib_antiguo = bibliotecas.get(row_bib).getNombre();
            bibliotecas.get(row_bib).setNombre(nueva.getNombre());
            bibliotecas.get(row_bib).setTelefono(nueva.getTelefono());
            bibliotecas.get(row_bib).setDireccion(nueva.getDireccion());
            bibliotecas.get(row_bib).setIdCiudad(nueva.getIdCiudad());
                 
            nueva.setIdBiblioteca(bibliotecas.get(row_bib).getIdBiblioteca());
            this.actualizar_biblioteca(bibliotecas.get(row_bib),bib_antiguo);
            this.rellenar_tabla_biblioteca();
            this.jTable_biblioteca.setVisible(false);
            this.jTable_biblioteca.setVisible(true);
            
        }else{
            
            try {   
                //TODO ¡¡¡
                consultar_ultimo_id_biblioteca();                
                id_bib+=1;
                System.out.println("ID=" + id_bib);
                nueva = new Biblioteca(this.jTextField_nombre_biblioteca.getText(),this.jTextField_telefono.getText(),this.jTextField_direccion.getText(),0);           
                nueva.setIdBiblioteca(id_bib);
                poner_id_biblioteca(nueva);//PARA PONER EL ID DE LA CIUDAD CUANDO SE MODIFICA, SE PONE EL SELECCIONADO
                bibliotecas.add(nueva);
                table_model_biblioteca.addRow(new Object[]{bibliotecas.get(this.bibliotecas.size()-1).getNombre(),bibliotecas.get(this.bibliotecas.size()-1).getTelefono()});
        
                try {
                    this.insertar_una_biblioteca(this.jTextField_nombre_biblioteca.getText(), this.jTextField_telefono.getText(), jTextField_direccion.getText(), bibliotecas.get(bibliotecas.size()-1).getIdCiudad());
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }            
        } 
        
        this.vaciar_campos_detallados_biblioteca();
        this.vaciar_biblioteca_modificar();
        this.editable_no_biblioteca();        
        this.modif_biblioteca=false;
        this.desactivar_botones_gc_biblioteca();
        this.activar_botones_amb_biblioteca();        
        this.jComboBox_biblioteca.removeAllItems();
    }//GEN-LAST:event_jButton_guardar_bibliotecaActionPerformed

    private void jButton_aniadir_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_libroActionPerformed
        this.editable_si_libro();
        this.vaciar_campos_detallados_libro();
        this.desactivar_botones_amb_libro();
        this.activar_botones_gc_libro();
        this.jTextField_nombre_libro.requestFocus();
        this.rellenar_todo_combo_libro();
    }//GEN-LAST:event_jButton_aniadir_libroActionPerformed

    private void jButton_modificar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_libroActionPerformed
        row_lib=this.jTable_libro.getSelectedRow();;
                
        this.modif_libro=true;        
        this.editable_si_libro();
        this.rellenar_campos_detallados_libro();
        this.rellenar_todo_combo_libro();
        this.rellenar_libro_modificar();
        this.activar_botones_gc_libro();
        this.desactivar_botones_amb_libro();
    }//GEN-LAST:event_jButton_modificar_libroActionPerformed

    private void jButton_borrar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_libroActionPerformed
        boolean borrar = true;
        
        int row = 0;
        row = this.jTable_libro.getSelectedRow();
        System.out.println("row= "+ row);
        if(personas.size()!=0){
            borrar = this.busqueda_id_libro_en_persona(borrar,row);  
        }              
        
        if(borrar == false){
            JOptionPane.showMessageDialog(null, "No puede borrar un libro asignado a una persona");
        }else{ 
            try {
                this.eliminar_un_libro(libros.get(row));
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
            table_model_libro.removeRow(row);
            this.libros.remove(row);
            table_model_libro.fireTableDataChanged();
            this.vaciar_campos_detallados_libro();           
            this.jComboBox_libro.removeAllItems();
        }
    }//GEN-LAST:event_jButton_borrar_libroActionPerformed

    private void jButton_guardar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_libroActionPerformed
        Libro nueva;
        if(modif_libro==true){
            nueva = new Libro(this.jTextField_nombre_libro.getText(),this.jTextField_autor.getText(),Integer.parseInt(this.jTextField_anio_publicacion.getText()),Integer.parseInt(this.jTextField_edad_recomendada.getText()),this.biblioteca_modificar.getIdBiblioteca());
            poner_id_libro(nueva);
            String lib_antiguo = libros.get(row_lib).getTitulo();
            libros.get(row_lib).setTitulo(nueva.getTitulo());
            libros.get(row_lib).setAutor(nueva.getAutor());
            libros.get(row_lib).setAnioPublicacion(nueva.getAnioPublicacion());
            libros.get(row_lib).setEdadRecomendada(nueva.getEdadRecomendada());
            libros.get(row_lib).setIdBiblioteca(nueva.getIdBiblioteca());
            
            nueva.setIdLibro(libros.get(row_lib).getIdLibro());
            this.actualizar_libro(libros.get(row_lib),lib_antiguo);
            this.rellenar_tabla_libro();
            this.jTable_libro.setVisible(false);
            this.jTable_libro.setVisible(true);
            
            
        }else{
            try {
                consultar_ultimo_id_libro();
                id_lib+=1;
                System.out.println("que vale id " + id_lib);
                nueva = new Libro(this.jTextField_nombre_libro.getText(),this.jTextField_autor.getText(),Integer.parseInt(this.jTextField_anio_publicacion.getText()),Integer.parseInt(this.jTextField_edad_recomendada.getText()),0);           
                nueva.setIdLibro(id_lib);
                poner_id_libro(nueva);
                libros.add(nueva);
                table_model_libro.addRow(new Object[]{libros.get(this.libros.size()-1).getTitulo(),libros.get(this.libros.size()-1).getAutor()});
            
                try {
                    this.insertar_un_libro(this.jTextField_nombre_libro.getText(), this.jTextField_autor.getText(), Integer.parseInt(this.jTextField_anio_publicacion.getText()), Integer.parseInt(this.jTextField_edad_recomendada.getText()), libros.get(libros.size()-1).getIdBiblioteca());
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }              
            
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        
        this.vaciar_campos_detallados_libro();
        this.vaciar_libro_modificar();
        this.editable_no_libro();        
        this.modif_libro=false;
        this.desactivar_botones_gc_libro();
        this.activar_botones_amb_libro();        
        this.jComboBox_libro.removeAllItems();
    }//GEN-LAST:event_jButton_guardar_libroActionPerformed

    private void jTable_libroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_libroMouseClicked
        this.rellenar_campos_detallados_libro();
    }//GEN-LAST:event_jTable_libroMouseClicked

    private void jButton_aniadir_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_personaActionPerformed
        this.editable_si_persona();
        this.vaciar_campos_detallados_persona();
        this.desactivar_botones_amb_persona();
        this.activar_botones_gc_persona();
        this.jTextField_nombre_persona.requestFocus();
        this.rellenar_todo_combo_persona();
    }//GEN-LAST:event_jButton_aniadir_personaActionPerformed

    private void jButton_borrar_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_personaActionPerformed
        int row = 0;
        row = this.jTable_persona.getSelectedRow();
        try {
            this.eliminar_una_persona(personas.get(row));
        } catch (SQLException ex) {
            Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
        }
        table_model_persona.removeRow(row);
        this.personas.remove(row);
        table_model_persona.fireTableDataChanged();
        this.vaciar_campos_detallados_persona();           
        this.jComboBox_persona.removeAllItems();        
    }//GEN-LAST:event_jButton_borrar_personaActionPerformed

    private void jButton_guardar_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_personaActionPerformed
        Persona nueva;
        if(modif_persona==true){
            nueva = new Persona(this.jTextField_DNI.getText(),this.jTextField_nombre_persona.getText(),this.jTextField_edad_persona.getText(),this.jTextField_ciudad_natal.getText(),this.persona_modificar.getIdLibro());
            poner_id_persona(nueva);
            String per_antiguo = personas.get(row_per).getNombre();
            personas.get(row_per).setDni(nueva.getDni());
            personas.get(row_per).setNombre(nueva.getNombre());
            personas.get(row_per).setEdad(nueva.getEdad());
            personas.get(row_per).setCiudadNatal(nueva.getCiudadNatal());
            personas.get(row_per).setIdLibro(nueva.getIdLibro());
            
            nueva.setIdPersona(personas.get(row_per).getIdPersona());
            this.actualizar_persona(personas.get(row_per),per_antiguo);
            this.rellenar_tabla_persona();
            this.jTable_persona.setVisible(false);
            this.jTable_persona.setVisible(true);
            
        }else{            
            try { 
                consultar_ultimo_id_persona();
                id_per+=1;
                nueva = new Persona(this.jTextField_DNI.getText(),this.jTextField_nombre_persona.getText(),this.jTextField_edad_persona.getText(),this.jTextField_ciudad_natal.getText(),0);           
                poner_id_persona(nueva);
                nueva.setIdPersona(id_per);
                personas.add(nueva);
                table_model_persona.addRow(new Object[]{personas.get(this.personas.size()-1).getNombre(),personas.get(this.personas.size()-1).getDni()});
            
                try {
                    this.insertar_una_persona(this.jTextField_DNI.getText(), this.jTextField_nombre_persona.getText(), this.jTextField_edad_persona.getText(), this.jTextField_ciudad_natal.getText(), personas.get(personas.size()-1).getIdLibro());
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.vaciar_campos_detallados_persona();
        this.vaciar_persona_modificar();
        this.editable_no_persona();        
        this.modif_persona=false;
        this.desactivar_botones_gc_persona();
        this.activar_botones_amb_persona();        
        this.jComboBox_persona.removeAllItems();
    }//GEN-LAST:event_jButton_guardar_personaActionPerformed

    private void jTable_personaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_personaMouseClicked
        this.rellenar_campos_detallados_persona();
    }//GEN-LAST:event_jTable_personaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing
    
    public void leer_ciudades() throws SQLException {   
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = (Query) s.createQuery("FROM Ciudad").setReadOnly(true);
        List<ORM.Ciudad> listciu = s.createQuery("FROM Ciudad").list();
        for (ORM.Ciudad unciu : listciu) {
            ciudades.add(unciu);
        }
        s.close();
    }
    
    public void insertar_una_ciudad (String nombre, String pais, int num_hab) throws SQLException{
        Transaction t = null;         
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        ORM.Ciudad ciu = new ORM.Ciudad();
        ciu.setNombre(nombre);
        ciu.setPais(pais);
        ciu.setNumHabitantes(num_hab);
        s.save(ciu);
        t.commit(); 
        s.refresh(ciu);
        s.close();
    }
    
    public void eliminar_una_ciudad(Ciudad ciu_del) throws SQLException{
        Transaction t = null;    
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        if (ciu_del != null) {
            s.delete(ciu_del);
            t.commit();
        }
        s.close();
    }
    
    public void consultar_ultimo_id_ciudad() throws SQLException{       
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = (Query) s.createQuery("FROM Ciudad").setReadOnly(true);
        List<ORM.Ciudad> listciu = s.createQuery("FROM Ciudad").list();
        ArrayList <Ciudad> ciu = new ArrayList();
        for (ORM.Ciudad unciu : listciu) {
            ciu.add(unciu);
        }        
        int id=0;
        for(int i = 0; i<ciu.size(); i++){
            if(id < ciu.get(i).getIdCiudad()){
                id=ciu.get(i).getIdCiudad();
            }
        }
        ciu.clear();
        id_ciu=id;
        s.close();
    }
    
    public void actualizar_ciudad(Ciudad ciu_mod, String nombre_antiguo) {
        Transaction t = null;
        Session s = NewHibernateUtil.getSessionFactory().openSession();        
        List<ORM.Ciudad> listciu = s.createQuery("FROM Ciudad WHERE nombre = '" + nombre_antiguo+ "'").list();
        Ciudad ciu_nue = listciu.get(0);
        ciu_nue.setNombre(ciu_mod.getNombre());
        ciu_nue.setPais(ciu_mod.getPais());
        ciu_nue.setNumHabitantes(ciu_mod.getNumHabitantes());
        t = s.beginTransaction(); 
        s.update(ciu_nue); 
        System.out.println("ciu_nue "+ ciu_mod.getNombre());
        t.commit();
        s.refresh(ciu_nue);
        s.close();
    }
   
    public void leer_bibliotecas() throws SQLException {  
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = (Query) s.createQuery("FROM Biblioteca").setReadOnly(true);
        List<ORM.Biblioteca> listbib = s.createQuery("FROM Biblioteca").list();
        for (ORM.Biblioteca unbib : listbib) {
            bibliotecas.add(unbib);
        }
        s.close();
    }
    
    public void insertar_una_biblioteca (String nombre, String telefono, String direccion, int id_ciu) throws SQLException{
        Transaction t = null;         
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        ORM.Biblioteca bib = new ORM.Biblioteca();
        bib.setNombre(nombre);
        bib.setTelefono(telefono);
        bib.setDireccion(direccion);
        bib.setIdCiudad(id_ciu);
        s.save(bib);
        t.commit(); 
        s.refresh(bib);
        s.close();
    }
    
    public void eliminar_una_biblioteca(Biblioteca bib_del) throws SQLException{
        Transaction t = null; 
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        if (bib_del != null) {
            s.delete(bib_del);
            t.commit();
        }
        s.close();
    }
    
    public void consultar_ultimo_id_biblioteca() throws SQLException{
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = (Query) s.createQuery("FROM Biblioteca").setReadOnly(true);
        List<ORM.Biblioteca> listbib = s.createQuery("FROM Biblioteca").list();
        ArrayList <Biblioteca> bib = new ArrayList();
        for (ORM.Biblioteca unbib : listbib) {
            bib.add(unbib);
        }        
        int id=0;
        for(int i = 0; i<bib.size(); i++){
            if(id < bib.get(i).getIdBiblioteca()){
                id=bib.get(i).getIdBiblioteca();
            }
        }
        bib.clear();
        id_bib=id;
        s.close();      
    }
    
    public void actualizar_biblioteca(Biblioteca bib_mod, String nombre_antiguo) {
        Transaction t = null;
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        List<ORM.Biblioteca> listbib = s.createQuery("FROM Biblioteca WHERE nombre = '" + nombre_antiguo+ "'").list();
        Biblioteca bib_nue = listbib.get(0);
        bib_nue.setNombre(bib_mod.getNombre());
        bib_nue.setTelefono(bib_mod.getTelefono());
        bib_nue.setDireccion(bib_mod.getDireccion());
        bib_nue.setIdCiudad(bib_mod.getIdCiudad());
        t = s.beginTransaction(); 
        s.update(bib_nue);
        System.out.println("bib_nue " + bib_mod.getNombre());
        t.commit();
        s.refresh(bib_nue);
        s.close();
    }
    
    public void leer_libro() throws SQLException {       
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = (Query) s.createQuery("FROM Libro").setReadOnly(true);
        List<ORM.Libro> listlib = s.createQuery("FROM Libro").list();
        for (ORM.Libro unlib : listlib) {
            libros.add(unlib);
        }
        s.close();
    }
    
    public void insertar_un_libro (String titulo, String autor, int anio_pub, int edad_rec, int id_bib) throws SQLException{
        Transaction t = null;         
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        ORM.Libro lib = new ORM.Libro();
        lib.setTitulo(titulo);
        lib.setAutor(autor);
        lib.setAnioPublicacion(anio_pub);
        lib.setEdadRecomendada(edad_rec);
        lib.setIdBiblioteca(id_bib);
        s.save(lib);
        t.commit(); 
        s.refresh(lib);
        s.close();
    }
    
    public void eliminar_un_libro(Libro lib_del) throws SQLException{
        Transaction t = null; 
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        if (lib_del != null) {
            s.delete(lib_del);
            t.commit();
        }
        s.close();
    }
    
    public void consultar_ultimo_id_libro() throws SQLException{
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = (Query) s.createQuery("FROM Libro").setReadOnly(true);
        List<ORM.Libro> listlib = s.createQuery("FROM Libro").list();
        ArrayList <Libro> lib = new ArrayList();
        for (ORM.Libro unlib : listlib) {
            lib.add(unlib);
        }        
        int id=0;
        for(int i = 0; i<lib.size(); i++){
            if(id < lib.get(i).getIdLibro()){
                id=lib.get(i).getIdLibro();
            }
        }
        lib.clear();
        id_lib=id;
        s.close();
    }
    
    public void actualizar_libro(Libro lib_mod, String nombre_antiguo) {
        Transaction t = null;
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        List<ORM.Libro> listlib = s.createQuery("FROM Libro WHERE titulo = '" + nombre_antiguo+ "'").list();
        Libro lib_nue =listlib.get(0);
        lib_nue.setTitulo(lib_mod.getTitulo());
        lib_nue.setAutor(lib_mod.getAutor());
        lib_nue.setAnioPublicacion(lib_mod.getAnioPublicacion());
        lib_nue.setEdadRecomendada(lib_mod.getEdadRecomendada());
        lib_nue.setIdBiblioteca(lib_mod.getIdBiblioteca());        
        t = s.beginTransaction(); 
        s.update(lib_nue); 
        System.out.println("lib_nue "+ lib_mod.getTitulo());
        t.commit();
        s.refresh(lib_nue);
        s.close();
    }
            
    public void leer_personas() throws SQLException {       
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = (Query) s.createQuery("FROM Persona").setReadOnly(true);
        List<ORM.Persona> listper = s.createQuery("FROM Persona").list();
        for (ORM.Persona unper : listper) {
            personas.add(unper);
        }
        s.close();
    }
    
    public void insertar_una_persona (String DNI, String nombre, String edad, String ciudad_nat, int id_lib) throws SQLException{
        Transaction t = null;         
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        ORM.Persona per = new ORM.Persona();
        per.setDni(DNI);
        per.setNombre(nombre);
        per.setEdad(edad);
        per.setCiudadNatal(ciudad_nat);
        per.setIdLibro(id_lib);
        s.save(per);
        t.commit(); 
        s.refresh(per);
        s.close();
    }
    
    public void eliminar_una_persona(Persona per_del) throws SQLException{
        Transaction t = null;
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        if (per_del != null) {
            s.delete(per_del);
            t.commit();
        }
        s.close();
    }
    
    public void consultar_ultimo_id_persona() throws SQLException{
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = (Query) s.createQuery("FROM Persona").setReadOnly(true);
        List<ORM.Persona> listper = s.createQuery("FROM Persona").list();
        ArrayList <Persona> per = new ArrayList();
        for (ORM.Persona unper : listper) {
            per.add(unper);
        }        
        int id=0;
        for(int i = 0; i<per.size(); i++){
            if(id < per.get(i).getIdPersona()){
                id=per.get(i).getIdPersona();
            }
        }
        per.clear();
        id_per=id;
        s.close();
    }
    
    public void actualizar_persona(Persona per_mod, String nombre_antiguo) {
        Transaction t = null;
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        List<ORM.Persona> listper = s.createQuery("FROM Persona WHERE nombre = '" + nombre_antiguo+ "'").list();
        Persona per_nue = listper.get(0);
        per_nue.setNombre(per_mod.getNombre());
        per_nue.setDni(per_mod.getDni());
        per_nue.setEdad(per_mod.getEdad());
        per_nue.setCiudadNatal(per_mod.getCiudadNatal());
        per_nue.setIdLibro(per_mod.getIdLibro());        
        t = s.beginTransaction(); 
        s.update(per_nue); 
        System.out.println("per_nue "+ per_mod.getNombre());
        t.commit();
        s.refresh(per_nue);
        s.close();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try {                
                    new Ventana1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_aniadir_biblioteca;
    private javax.swing.JButton jButton_aniadir_ciudad;
    private javax.swing.JButton jButton_aniadir_libro;
    public javax.swing.JButton jButton_aniadir_persona;
    private javax.swing.JButton jButton_borrar_biblioteca;
    private javax.swing.JButton jButton_borrar_ciudad;
    private javax.swing.JButton jButton_borrar_libro;
    public javax.swing.JButton jButton_borrar_persona;
    private javax.swing.JButton jButton_cancelar_biblioteca;
    private javax.swing.JButton jButton_cancelar_ciudad;
    public javax.swing.JButton jButton_cancelar_libro;
    private javax.swing.JButton jButton_cancelar_persona;
    private javax.swing.JButton jButton_guardar_biblioteca;
    private javax.swing.JButton jButton_guardar_ciudad;
    public javax.swing.JButton jButton_guardar_libro;
    private javax.swing.JButton jButton_guardar_persona;
    private javax.swing.JButton jButton_modificar_biblioteca;
    private javax.swing.JButton jButton_modificar_ciudad;
    private javax.swing.JButton jButton_modificar_libro;
    public javax.swing.JButton jButton_modificar_persona;
    public javax.swing.JComboBox<String> jComboBox_biblioteca;
    public javax.swing.JComboBox<String> jComboBox_libro;
    private javax.swing.JComboBox<String> jComboBox_persona;
    private javax.swing.JLabel jLabel_DNI;
    private javax.swing.JLabel jLabel_anio_publicacion;
    private javax.swing.JLabel jLabel_autor;
    private javax.swing.JLabel jLabel_biblioteca_libro;
    private javax.swing.JLabel jLabel_ciudad_natal;
    private javax.swing.JLabel jLabel_ciudades_bibliotecas;
    private javax.swing.JLabel jLabel_direccion;
    private javax.swing.JLabel jLabel_edad_persona;
    private javax.swing.JLabel jLabel_edad_recomendada;
    private javax.swing.JLabel jLabel_libro_persona;
    private javax.swing.JLabel jLabel_nombre_biblioteca;
    private javax.swing.JLabel jLabel_nombre_ciudad;
    private javax.swing.JLabel jLabel_nombre_libro;
    private javax.swing.JLabel jLabel_nombre_persona;
    private javax.swing.JLabel jLabel_num_habitantes;
    private javax.swing.JLabel jLabel_pais;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JPanel jPanel_biblioteca;
    private javax.swing.JPanel jPanel_ciudad;
    private javax.swing.JPanel jPanel_libro;
    private javax.swing.JPanel jPanel_persona;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable_biblioteca;
    private javax.swing.JTable jTable_ciudad;
    private javax.swing.JTable jTable_libro;
    public javax.swing.JTable jTable_persona;
    private javax.swing.JTextField jTextField_DNI;
    private javax.swing.JTextField jTextField_anio_publicacion;
    private javax.swing.JTextField jTextField_autor;
    private javax.swing.JTextField jTextField_ciudad_natal;
    public javax.swing.JTextField jTextField_direccion;
    private javax.swing.JTextField jTextField_edad_persona;
    private javax.swing.JTextField jTextField_edad_recomendada;
    public javax.swing.JTextField jTextField_nombre_biblioteca;
    public javax.swing.JTextField jTextField_nombre_ciudad;
    private javax.swing.JTextField jTextField_nombre_libro;
    private javax.swing.JTextField jTextField_nombre_persona;
    public javax.swing.JTextField jTextField_num_habitantes;
    public javax.swing.JTextField jTextField_pais;
    public javax.swing.JTextField jTextField_telefono;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Ciudad> ciudades;
    private Ciudad ciudad_modificar;
    private DefaultTableModel table_model_ciudad;    
    private Boolean modif_ciudad;
    private int id_ciu;
    private int row_ciu;
    
    private ArrayList<Biblioteca> bibliotecas;
    private Biblioteca biblioteca_modificar;
    private DefaultTableModel table_model_biblioteca;    
    private Boolean modif_biblioteca;
    private int id_bib;
    private int row_bib;
    
    private ArrayList<Libro> libros;
    private Libro libro_modificar;
    private DefaultTableModel table_model_libro;    
    private Boolean modif_libro;
    private int id_lib;
    private int row_lib;
    
    private ArrayList<Persona> personas;
    private Persona persona_modificar;
    private DefaultTableModel table_model_persona;    
    private Boolean modif_persona;
    private int id_per;
    private int row_per;
  
}
