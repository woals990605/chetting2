package site.metacoding.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatClientProgram extends JFrame{
	
	//GUI ����
	JPanel northPanel, southPanel;
	TextArea chatList;
	ScrollPane scroll;
	JTextField txtHost, txtPort, txtMsg;
	JButton btnConnect, btnSend;
	
	//��� ����
	Socket socket;
	BufferedReader reader;
	BufferedWriter writer;
	
	public ChatClientProgram() {
		initListener();
		
		setVisible(true);
	}
		Private void  initUI() {
			
		//��� ������
		northPanel =new JPanel();
		txtHost = new JTextField(20);
		txtHost.setText("127.0.0.1");
		txtPort = new JTextField(5);
		txtPort .setText("5000");
		btnConnect = new JButton("Connect");
		northPanel.add(txtHost);
		northPanel.add(txtPort);
		northPanel.add(btnConnect);
		
		//�ϴ� ������
		southPanel = new JPanel();
		txtMsg = new JTextField(25);
		btnSend = new JButton("send");
		southPanel.add(txtMsg);
		southPanel.add(btnSend);
		
		//���� ������
		chatList = new TextArea(10,30);
		chatList.setBackground(Color.ORANGE);
		chatList.setForeground(Color.BLUE);
		scroll = new ScrollPane();
		scroll.add(chatList);
		
		//������ ����
		setTitle("MyChat1.0");
		setSize(400,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(northPanel, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		}
		
	
	
	private void initListener() {
		btnConnect.addActionListener((e)->{
			String host = txtHost.getText();
			String port = txtPort.getText();
			System.out.println(host+"������"+port+"��Ʈ�� �����մϴ�.");
		});
		
		btnSend.addActionListener((e)->{
			String msg= txtMsg.getText();
			chatList.append(msg+"\n");
			txtMsg.requestFocus();
		});
	}

	public static void main(String[] args) {
		new ChatClientProgram();

	}

}
