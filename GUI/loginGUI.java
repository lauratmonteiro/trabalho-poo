/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author PC
 */
public class loginGUI {
    
    private static JLabel usuario;
    private static JTextField campoUsuario;
    private static JLabel senha;
    private static JTextField campoSenha;
    private static JButton botaoEnviar;
    private static JLabel sucesso;
    
    public loginGUI(){
        
        JPanel painel = new JPanel();
        
        JFrame frame = new JFrame();
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(painel);
        
        painel.setLayout(null);
        usuario = new JLabel("Usuário: ");
        usuario.setBounds(10, 20 ,80, 25);
        painel.add(usuario);
        
        campoUsuario = new JTextField(20);
        campoUsuario.setBounds(100, 20, 165, 25);
        painel.add(campoUsuario);
        
        senha = new JLabel("Senha: ");
        senha.setBounds(10, 50 ,80, 25);
        painel.add(senha);
        
        campoSenha= new JTextField(20);
        campoSenha.setBounds(100, 50, 165, 25);
        painel.add(campoSenha);
        
        botaoEnviar = new JButton("Login");
        botaoEnviar.setBounds(10, 80, 80, 25);
        botaoEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Evento
                String usuarioDigitado = campoUsuario.getText();
                String senhaDigitada = campoSenha.getText();
                if(usuarioDigitado.equals("Admin") && senhaDigitada.equals("admin")){
                    /*TODO: Redirecionar para a página do funciário*/
                    sucesso.setText("Bem-vindo funcionário! LOGANDO ....");
                }else if(usuarioDigitado.equals("Cliente") && senhaDigitada.equals("cliente")){
                    /*TODO: Redirecionar para a página do cliente*/
                    sucesso.setText("Bem-vindo cliente! LOGANDO ....");
                }else{
                    sucesso.setText("Usuário ou senha inválido!");
                }
            }
        });
        painel.add(botaoEnviar);
        
        sucesso = new JLabel("");
        sucesso.setBounds(10, 110, 300, 25);
        painel.add(sucesso);
       
       frame.setVisible(true);
       
    }
    
    public static void main(String[] args) {
              
        loginGUI login = new loginGUI();
   
    }
    
}

