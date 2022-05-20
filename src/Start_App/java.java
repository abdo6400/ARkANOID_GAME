/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start_App;
import java.awt.*;
import GameMenu.GameMenu;
public class java {
     public static void main(String[] args) {
    	EventQueue.invokeLater( () -> {
    		new GameMenu();
    	 });  
     }
}
