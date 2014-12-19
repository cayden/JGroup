package com.platform.test;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
/**
 * �����վݰ�
 *
 */
public class Receive2 extends ReceiverAdapter
{
	JChannel channel;
	String user_name = System.getProperty("user.name", "n/a");
	
	public static void main(String[] args) throws Exception
	{
		//�����վݶ�
		new Receive2().start();
	}
	
	private void start() throws Exception
	{
		//����һ��ͨ��
		channel = new JChannel();
		//����һ��������
		channel.setReceiver(this);
		//����һ��Ⱥ
		channel.connect("ChatCluster");
	}

	//���Ǹ���ķ���
	@Override
	public void receive(Message msg)
	{
		//����μ�msg�Ĳ���
		String receiveData=(String)msg.getObject();
		System.out.println("  ��������������:  " +receiveData);
	}

	@Override
	public void viewAccepted(View new_view)
	{
		System.out.println("** view: " + new_view);
	}
}

