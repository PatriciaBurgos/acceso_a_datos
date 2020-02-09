/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sextaentrega_xmldb;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.xquery.XQConnection; 
import javax.xml.xquery.XQException; 
import javax.xml.xquery.XQResultSequence; 
import javax.xml.xquery.XQExpression; 
import javax.xml.stream.XMLStreamReader; 
import javax.xml.stream.XMLStreamConstants; 
import javax.xml.xquery.XQDataSource;

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void jButton_cancelar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_ciudadActionPerformed
        if(modif_ciudad==true){
            Ciudad nuevo = new Ciudad(ciudad_modificar.getNombre(),ciudad_modificar.getPais(),ciudad_modificar.getNumHabitantes());

            ciudades.add(nuevo);
            table_model_ciudad.addRow(new Object[]{ciudades.get(this.ciudades.size()-1).getNombre(),ciudades.get(this.ciudades.size()-1).getPais()});

            try {
                //Podria fallar por el id
                this.insertar_una_ciudad(ciudades.get(ciudades.size()).getIdCiudad(),this.jTextField_nombre_ciudad.getText(), this.jTextField_pais.getText(), Integer.parseInt(this.jTextField_num_habitantes.getText()));
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

    private void jButton_guardar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_ciudadActionPerformed
        Ciudad nueva;
        if(modif_ciudad==true){
            nueva = new Ciudad(this.jTextField_nombre_ciudad.getText(),this.jTextField_pais.getText(),Integer.parseInt(this.jTextField_num_habitantes.getText()));
            String ciu_antiguo = ciudades.get(row_ciu).getNombre();
            ciudades.get(row_ciu).setNombre(this.jTextField_nombre_ciudad.getText());
            ciudades.get(row_ciu).setPais(this.jTextField_pais.getText());
            ciudades.get(row_ciu).setNumHabitantes(Integer.parseInt(this.jTextField_num_habitantes.getText()));

            nueva.setIdCiudad(ciudades.get(row_ciu).getIdCiudad());
            this.actualizar_ciudad(ciudades.get(row_ciu));
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
                    this.insertar_una_ciudad(id_ciu,this.jTextField_nombre_ciudad.getText(), this.jTextField_pais.getText(), Integer.parseInt(this.jTextField_num_habitantes.getText()));
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

    private void jTextField_nombre_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombre_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombre_ciudadActionPerformed

    private void jButton_borrar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_ciudadActionPerformed
        int row = 0;
        row = this.jTable_ciudad.getSelectedRow();

        boolean borrar = true;
        
        if(borrar == false){
            JOptionPane.showMessageDialog(null, "No puede borrar una ciudad asignada a una biblioteca");
        }else{
            try {
                this.eliminar_una_ciudad(ciudades.get(row).getIdCiudad());
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

    private void jButton_aniadir_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_ciudadActionPerformed
        this.editable_si_ciudad();
        this.vaciar_campos_detallados_ciudad();
        this.desactivar_botones_amb_ciudad();
        this.activar_botones_gc_ciudad();
        this.jTextField_nombre_ciudad.requestFocus();
    }//GEN-LAST:event_jButton_aniadir_ciudadActionPerformed

    private void jTable_ciudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ciudadMouseClicked
        this.rellenar_campos_detallados_ciudad();
    }//GEN-LAST:event_jTable_ciudadMouseClicked
    
    private static String nomClaseDS = "net.xqj.exist.ExistXQDataSource"; 
	
    private static XQConnection obtenConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XQException {
        XQDataSource xqs = (XQDataSource) Class.forName(nomClaseDS).newInstance();
        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");
        xqs.setProperty("user", "admin");
        xqs.setProperty("password","root");
        return xqs.getConnection();
    }

    private static void muestraErrorXQuery (XQException e){
        System.err.println("Xquery ERROR mensaje: " + e.getMessage());
        System.err.println("Xquery ERROR causa: " + e.getCause());
        System.err.println("Xquery ERROR código: " + e.getVendorCode());
    } 
    
    public String limpiar_cadena (String cad){
        cad=cad.replace("\n","");
        cad=cad.replace(" ","");
        cad=cad.replace("\t","");
        cad=cad.replace("\r","");
        return cad;
    }
    
    public void leer_ciudades() throws SQLException {   
        
        //ES LO QUE ME FALTA
        
        XQConnection c = null; 
        try { 
            c = obtenConexion(); 
            
            //Consulta 
            String cad = "doc('/db/ciudades/Ciudades.xml')/Ciudades/Ciudad"; 
            XQExpression xqe = c.createExpression(); 
            XQResultSequence xqrs = xqe.executeQuery(cad); 
            int i=1; 
            int cont;
            String cadena;
            Ciudad ciu;
            
            while (xqrs.next()) { 
                System.out.println("[Resultado "+(i++)+"]"); 
                XMLStreamReader xsr = xqrs.getItemAsStream();                 
                cont=0;
                ciu = new Ciudad();
                
                while (xsr.hasNext()) { 

                    if (xsr.getEventType() == XMLStreamConstants.CHARACTERS) { 
                        String aux2 = String.valueOf(xsr.getText());                        
                        System.out.println(xsr.getText());
                        
                        
                        cadena = limpiar_cadena(xsr.getText());
                        System.out.println(cadena);
                        
                        if(!cadena.equals("") && cont == 0){
                            ciu.setIdCiudad(Integer.valueOf(cadena));
                            cont++;
                        }else if(!cadena.equals("") && cont == 1){
                            ciu.setNombre(cadena);
                            cont++;
                        }else if(!cadena.equals("") && cont == 2){
                            ciu.setPais(cadena);
                            cont++;
                        }else if(!cadena.equals("") && cont == 3){
                            ciu.setNumHabitantes(Integer.valueOf(cadena));
                            cont++;
                        }else if(cont==4){
                            this.ciudades.add(ciu);
                            cont++;
                        }
                    } 
                    xsr.next(); 
                } 
            } 
        } 
        catch (XQException e) { 
            muestraErrorXQuery(e);
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        finally { 
            try { 
                if (c != null) { 
                    c.close(); 
                } 
            } 
            catch (XQException xe) { 
                xe.printStackTrace(); 
            } 
        }  
           
    }
    
    public void insertar_una_ciudad (int id, String nombre, String pais, int num_hab) throws SQLException{
        XQConnection c = null; 
        try { 
            c = obtenConexion(); 
        
        String cad = "update insert"
                    + "<Ciudad>"
                    + "<id_ciudad>"+id+"</id_ciudad>"
                    + "<nombre>"+nombre+"</nombre>"
                    + "<pais>"+pais+"</pais>"
                    + "<num_habitantes>"+num_hab+"</num_habitantes>"                
                    + "</Ciudad>"
                    + "into doc('/db/ciudades/Ciudades.xml')/Ciudades"; 
        XQExpression xqe = c.createExpression();
        xqe.executeCommand(cad);
            
        } 
        catch (XQException e) { 
            muestraErrorXQuery(e);
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        finally { 
            try { 
                if (c != null) { 
                    c.close(); 
                } 
            } 
            catch (XQException xe) { 
                xe.printStackTrace(); 
            } 
        } 
    }
    
    public void eliminar_una_ciudad(int id) throws SQLException{
        XQConnection c = null; 
        try { 
            c = obtenConexion(); 
            String cad ="update delete doc ('/db/ciudades/Ciudades.xml')/Ciudades/Ciudad[id_ciudad="+id+"]";
            XQExpression xqe = c.createExpression();
            xqe.executeCommand(cad);
        }catch (XQException e) { 
            muestraErrorXQuery(e);
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        finally { 
            try { 
                if (c != null) { 
                    c.close(); 
                } 
            } 
            catch (XQException xe) { 
                xe.printStackTrace(); 
            } 
        }
    }
    
    public void consultar_ultimo_id_ciudad() throws SQLException{       
        XQConnection c = null; 
        id_ciu=0;
        try { 
            c = obtenConexion();         
            String cad = "doc('/db/ciudades/Ciudades.xml')/Ciudades/Ciudad/id_ciudad"; 
            XQExpression xqe = c.createExpression(); 
            XQResultSequence xqrs = xqe.executeQuery(cad); 
            int i=1; 
            while (xqrs.next()) { 
                System.out.println("[Resultado "+(i++)+"]"); 
                XMLStreamReader xsr = xqrs.getItemAsStream(); 
                
                while (xsr.hasNext()) { 
                    if (xsr.getEventType() == XMLStreamConstants.CHARACTERS) { 
                        System.out.println(xsr.getText());
                        if(id_ciu<Integer.valueOf(xsr.getText())){
                            id_ciu=Integer.valueOf(xsr.getText());
                        }
                    } 
                    xsr.next(); 
                } 
            } 
        }catch (XQException e) { 
            muestraErrorXQuery(e);
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        finally { 
            try { 
                if (c != null) { 
                    c.close(); 
                } 
            } 
            catch (XQException xe) { 
                xe.printStackTrace(); 
            } 
        }
    }
    
    public void actualizar_ciudad(Ciudad ciu_mod) {
        XQConnection c = null; 
        try { 
            c = obtenConexion(); 
            String cad ="update replace doc('/db/ciudades/Ciudades.xml')/Ciudades/Ciudad[id_ciudad="+ciu_mod.getIdCiudad()+"]" +
                            "with"+
                            "<Ciudad>" +
                            "<id_ciudad>"+ciu_mod.getIdCiudad()+"</id_ciudad>\n" +
                            "<nombre>"+ciu_mod.getNombre()+"</nombre>\n" +
                            "<pais>"+ciu_mod.getPais()+"</pais>\n" +
                            "<num_habitantes>"+ciu_mod.getNumHabitantes()+"</num_habitantes>\n" +
                            "</Ciudad>";
            XQExpression xqe = c.createExpression();
            xqe.executeCommand(cad);
        }catch (XQException e) { 
            muestraErrorXQuery(e);
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        finally { 
            try { 
                if (c != null) { 
                    c.close(); 
                } 
            } 
            catch (XQException xe) { 
                xe.printStackTrace(); 
            } 
        }
        
        
        
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
    private javax.swing.JButton jButton_aniadir_ciudad;
    private javax.swing.JButton jButton_borrar_ciudad;
    private javax.swing.JButton jButton_cancelar_ciudad;
    private javax.swing.JButton jButton_guardar_ciudad;
    private javax.swing.JButton jButton_modificar_ciudad;
    private javax.swing.JLabel jLabel_nombre_ciudad;
    private javax.swing.JLabel jLabel_num_habitantes;
    private javax.swing.JLabel jLabel_pais;
    private javax.swing.JPanel jPanel_ciudad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable_ciudad;
    private javax.swing.JTextField jTextField_nombre_ciudad;
    private javax.swing.JTextField jTextField_num_habitantes;
    private javax.swing.JTextField jTextField_pais;
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
