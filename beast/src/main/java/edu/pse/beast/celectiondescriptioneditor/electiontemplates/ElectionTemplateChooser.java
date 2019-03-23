//package edu.pse.beast.celectiondescriptioneditor.electiontemplates;
//
//import java.util.Iterator;
//
//import javax.swing.JOptionPane;
//import javax.swing.WindowConstants;
//
//import edu.pse.beast.celectiondescriptioneditor.useractions.NewElectionUserAction;
//import edu.pse.beast.datatypes.electiondescription.ElectionTypeContainer;
//import edu.pse.beast.pluginhandler.TypeLoader;
//import edu.pse.beast.stringresource.StringResourceLoader;
//import edu.pse.beast.types.InputType;
//import edu.pse.beast.types.OutputType;
//
///**
// *
// * @author Holger Klein
// */
//public class ElectionTemplateChooser extends javax.swing.JFrame {
//
//  private static final long serialVersionUID = 1L;
//
//  // Variables declaration - do not modify//GEN-BEGIN:variables
//  private javax.swing.JButton createButton;
//  private javax.swing.JComboBox<String> inputList;
//  private javax.swing.JLabel jLabel1;
//  private javax.swing.JLabel jLabel2;
//  private javax.swing.JLabel name;
//  private javax.swing.JTextField nameField;
//  private javax.swing.JComboBox<String> resultList;
//
//  // End of variables declaration//GEN-END:variables
//
//  /**
//     * Creates new form ElectionTemplateChooser
//     * @param action the action performed by the user
//     * @param electionTemplateHandler the template handler
//     * @param loader the loader for the string resources
//     * @param emptyNameTextFieldError error that gets shown when the string is empty
//     */
//    public ElectionTemplateChooser(NewElectionUserAction action, ElectionTemplateHandler electionTemplateHandler,
//            StringResourceLoader loader, String emptyNameTextFieldError) {
//        initComponents();
//
//        createButton.setText(loader.getStringFromID("create"));
//
//        createButton.addActionListener((ae) -> {
//            if (nameField.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, emptyNameTextFieldError, "", JOptionPane.OK_OPTION);
//            } else {
//              ElectionTypeContainer container =
//                  new ElectionTypeContainer(
//                      TypeLoader.getAvailableInputTypes().get(inputList.getSelectedIndex()),
//                      TypeLoader.getAvailableOutputTypes().get(resultList.getSelectedIndex()));
//
//                action.create(container,
//                        nameField.getText());
//                this.dispose();
//            }
//        });
//
//        for (Iterator<InputType> iterator = TypeLoader.getAvailableInputTypes().iterator(); iterator.hasNext();) {
//          InputType inType = (InputType) iterator.next();
//      inputList.addItem(inType.getInputIDinFile());
//    }
//
//        for (Iterator<OutputType> iterator = TypeLoader.getAvailableOutputTypes().iterator(); iterator.hasNext();) {
//          OutputType inType = (OutputType) iterator.next();
//      resultList.addItem(inType.getOutputIDinFile());
//    }
//
//        getRootPane().setDefaultButton(createButton);
//    }
//
//  /**
//   * This method is called from within the constructor to initialize the form.
//   * WARNING: Do NOT modify this code. The content of this method is always
//   * regenerated by the Form Editor.
//   */
//  // <editor-fold defaultstate="collapsed" desc="Generated
//  // Code">//GEN-BEGIN:initComponents
//  private void initComponents() {
//
//    jLabel1 = new javax.swing.JLabel();
//    jLabel2 = new javax.swing.JLabel();
//    createButton = new javax.swing.JButton();
//    inputList = new javax.swing.JComboBox<>();
//    resultList = new javax.swing.JComboBox<>();
//    name = new javax.swing.JLabel();
//    nameField = new javax.swing.JTextField();
//
//    setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//
//    jLabel1.setText("Input");
//
//    jLabel2.setText("Result");
//
//    createButton.setText("create");
//
//    name.setText("name");
//
//    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//    getContentPane().setLayout(layout);
//    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//        .addGroup(layout.createSequentialGroup().addGroup(layout
//            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup().addComponent(jLabel2)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
//                    resultList, javax.swing.GroupLayout.PREFERRED_SIZE,
//                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//            .addGroup(layout.createSequentialGroup().addComponent(jLabel1)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(inputList, javax.swing.GroupLayout.PREFERRED_SIZE,
//                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
//            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGroup(layout.createSequentialGroup().addGap(0, 252, Short.MAX_VALUE)
//                    .addComponent(createButton))
//                .addGroup(layout.createSequentialGroup().addGap(4, 4, 4).addComponent(name)
//                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                    .addComponent(nameField)))
//            .addContainerGap()));
//    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
//        .createSequentialGroup().addContainerGap()
//        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
//            .addComponent(inputList, javax.swing.GroupLayout.PREFERRED_SIZE,
//                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//            .addComponent(name).addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE,
//                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//        .addGap(32, 32, 32)
//        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
//            .addComponent(createButton).addComponent(resultList, javax.swing.GroupLayout.PREFERRED_SIZE,
//                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
//
//    pack();
//  } // </editor-fold>//GEN-END:initComponents
//}
