/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tableView;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import srh.project.Books;

/**
 *
 * @author Admin
 */
public interface tableViewer {
    public static void tableImplement(Books b, DefaultTableModel model, String id, String searchTxt){
        ArrayList<Books> bmodel=new ArrayList<Books>();
        bmodel=b.getBookResult(id, searchTxt);
        Object[] rowData = new Object[8];
        for(int i=0;i<bmodel.size();i++){
            //model.addRow(rowData);
            rowData[0]=bmodel.get(i).getISBN();
            rowData[1]=bmodel.get(i).getName();
            rowData[2]=bmodel.get(i).getAuthor();
            rowData[3]=bmodel.get(i).getPublisher();
            rowData[4]=bmodel.get(i).getPubliserYear();
            rowData[5]=bmodel.get(i).getGenre();
            rowData[6]="$"+bmodel.get(i).getPrice();
            rowData[7]=bmodel.get(i).getEdition();
            
            model.addRow(rowData);
        }
    }
}
