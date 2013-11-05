package com.hehe.wakaka;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hehe.wakaka.Tetris.HandleAct;

public class ConfirmDlg implements ActionListener {
	Dialog dlg;
	Label message = new Label("是否关闭窗口～");
	Button btnY = new Button("yes");
	Button btnN = new Button("no");

	Panel p1 = new Panel();
	Panel p2 = new Panel();
	boolean ans;

	ConfirmDlg(Frame own) {
		btnY.addActionListener(this);
		btnN.addActionListener(this);

		dlg = new Dialog(own, "确认对话框", true);
		p1.add(message);
		p2.add(btnN);
		p2.add(btnY);

		dlg.add(p1, BorderLayout.NORTH);
		dlg.add(p2, BorderLayout.SOUTH);
		dlg.setSize(200, 100);
		dlg.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dlg.dispose();
		if (e.getActionCommand() == "yes") {
			ans = true;
		} else {
			ans = false;
		}
	}

}
