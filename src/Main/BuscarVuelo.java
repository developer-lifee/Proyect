
package Main;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import dao.VueloDAO;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import model.Vuelo;



public class BuscarVuelo extends javax.swing.JFrame {
    private JTable tablaVuelos;
    private DefaultTableModel modeloTabla;
    /**
     * Creates new form BuscarVuelo
     */
    public BuscarVuelo() {
        tablaVuelos = new JTable();
        modeloTabla = new DefaultTableModel();
        panelMarca = new javax.swing.JPanel();
        initComponents();
        inicializarTabla();
    }
       private void inicializarTabla() {
        // CAMBIO: Configuración del modelo de la tabla
        String[] columnNames = {"Código Vuelo", "Origen", "Destino", "Fecha", "Hora", "Precio"};
        modeloTabla = new DefaultTableModel(columnNames, 0);
        tablaVuelos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaVuelos);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);
       }
       
private void cargarVuelos(String aerolinea) {
       //Implementación del método cargarVuelos
        modeloTabla.setRowCount(0);
        List<Vuelo> vuelos = new VueloDAO().obtenerVuelosPorAerolinea(aerolinea);
        for (Vuelo vuelo : vuelos) {
            modeloTabla.addRow(new Object[]{
                vuelo.getCodigoVuelo(),
                vuelo.getOrigen(),
                vuelo.getDestino(),
                vuelo.getHoraSalida(),
                vuelo.getHoraLlegada().toString(),
                vuelo.getPrecio()
            });
        }
    }

private void cargarVuelosPorRuta(String origen, String destino) {
    // Limpiar tabla
    modeloTabla.setRowCount(0);
    // Llamada al método DAO para obtener vuelos por ruta
    List<Vuelo> vuelos = new VueloDAO().obtenerVuelosPorRuta(origen, destino);
    for (Vuelo vuelo : vuelos) {
        modeloTabla.addRow(new Object[]{
            vuelo.getCodigoVuelo(),
            vuelo.getOrigen(),
            vuelo.getDestino(),
            vuelo.getHoraSalida(),
            vuelo.getHoraLlegada().toString(),
            vuelo.getPrecio()
        });
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelMarca = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        wingoButton = new javax.swing.JButton();
        aviancaButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        inicioButton = new javax.swing.JButton();
        panelTodo = new javax.swing.JPanel();
        labelOrigen = new javax.swing.JLabel();
        origenField = new javax.swing.JTextField();
        labelDestino = new javax.swing.JLabel();
        destinoField = new javax.swing.JTextField();
        vuelosDisponiblesLBL = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        buscarButton = new javax.swing.JButton();
        reservasButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelMarca.setBackground(new java.awt.Color(255, 153, 51));
        panelMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        logoLabel.setFont(new java.awt.Font("Bernard MT Condensed", 0, 24)); // NOI18N
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("FAST FLYER");

        javax.swing.GroupLayout panelMarcaLayout = new javax.swing.GroupLayout(panelMarca);
        panelMarca.setLayout(panelMarcaLayout);
        panelMarcaLayout.setHorizontalGroup(
            panelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMarcaLayout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMarcaLayout.setVerticalGroup(
            panelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMarcaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoLabel))
        );

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        wingoButton.setText("Wingo");
        wingoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wingoButtonActionPerformed(evt);
            }
        });

        aviancaButton.setText("Avianca");
        aviancaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aviancaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(wingoButton)
                .addGap(186, 186, 186)
                .addComponent(aviancaButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wingoButton)
                    .addComponent(aviancaButton))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        inicioButton.setBackground(new java.awt.Color(102, 255, 255));
        inicioButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        inicioButton.setText("Inicio");
        inicioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inicioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inicioButton)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTodo.setBackground(new java.awt.Color(255, 255, 255));

        labelOrigen.setText("Origen");

        origenField.setText("Ciudad 1");
        origenField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origenFieldActionPerformed(evt);
            }
        });

        labelDestino.setText("Destino");

        destinoField.setText("Ciudad 2");
        destinoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoFieldActionPerformed(evt);
            }
        });

        vuelosDisponiblesLBL.setBackground(new java.awt.Color(255, 255, 255));
        vuelosDisponiblesLBL.setText("VUELOS DISPONIBLES");
        vuelosDisponiblesLBL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTodoLayout = new javax.swing.GroupLayout(panelTodo);
        panelTodo.setLayout(panelTodoLayout);
        panelTodoLayout.setHorizontalGroup(
            panelTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTodoLayout.createSequentialGroup()
                .addGroup(panelTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTodoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(labelOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(origenField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(labelDestino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinoField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarButton))
                    .addGroup(panelTodoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vuelosDisponiblesLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        panelTodoLayout.setVerticalGroup(
            panelTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTodoLayout.createSequentialGroup()
                .addGroup(panelTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOrigen)
                    .addComponent(origenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDestino)
                    .addComponent(destinoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarButton))
                .addGap(40, 40, 40)
                .addComponent(vuelosDisponiblesLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePanel.getAccessibleContext().setAccessibleParent(tablePanel);

        reservasButton.setText("Ver Reservas");
        reservasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(reservasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reservasButton)
                        .addGap(0, 70, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioButtonActionPerformed

    private void origenFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origenFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origenFieldActionPerformed
    

    
    private void reservasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasButtonActionPerformed
    
    int filaSeleccionada = tablaVuelos.getSelectedRow();
    String codigoVuelo = (String) tablaVuelos.getValueAt(filaSeleccionada, 0);

// Create an instance of the Buscar class
    Wingo wingo = new Wingo(codigoVuelo);
    // Set the visibility of the Buscar class to true
    wingo.setVisible(true);
    wingo.inicializar(codigoVuelo);
    // Hide the Usuario class
    this.setVisible(false); // TODO add your handling code here:
    }//GEN-LAST:event_reservasButtonActionPerformed

    private void wingoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wingoButtonActionPerformed
         cargarVuelos("Wingo");
    }//GEN-LAST:event_wingoButtonActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
           // Obtener los valores de los campos de entrada
    String origen = origenField.getText();
    String destino = destinoField.getText();
    cargarVuelosPorRuta(origen, destino);
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void destinoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoFieldActionPerformed

    private void aviancaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aviancaButtonActionPerformed
         cargarVuelos("Avianca");
    }//GEN-LAST:event_aviancaButtonActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BuscarVuelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aviancaButton;
    private javax.swing.JButton buscarButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JTextField destinoField;
    private javax.swing.JButton inicioButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelDestino;
    private javax.swing.JLabel labelOrigen;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTextField origenField;
    private javax.swing.JPanel panelMarca;
    private javax.swing.JPanel panelTodo;
    private javax.swing.JButton reservasButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel vuelosDisponiblesLBL;
    private javax.swing.JButton wingoButton;
    // End of variables declaration//GEN-END:variables
}
