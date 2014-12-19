package com.platform.test;
import org.jgroups.ChannelClosedException;
import org.jgroups.ChannelNotConnectedException;
import org.jgroups.JChannel;
import org.jgroups.Message;
/**
 * �������ݿͻ���
 *
 */
public class Send 
{
    JChannel channel;
    //�õ��������Ե� �û�����
    String user_name=System.getProperty("user.name", "n/a");
    private void start() throws Exception 
    {
    	/**
    	 * ������ָ��Channelʹ�õ�Э��ջ������ǿյģ���ʹ��Ĭ�ϵ�Э��ջ��
    	 * λ��JGroups�����udp.xml������������һ����ð�ŷָ����ַ�����
    	 * ����һ��XML�ļ�����XML�ļ��ﶨ��Э��ջ�� 
    	 */
        //����һ��ͨ��
        channel=new JChannel();        
        //����һ��Ⱥ
        channel.connect("ChatCluster");
        //�����¼�
        sendEvent();
        //�ر�ͨ��
        channel.close();
    }

    /**
     * ��Ҫ�����¼�
     */
    private void sendEvent() 
    {
     	try
		{
    		String str="2222";//���͵��ַ���
    		//�����Message�ĵ�һ�������Ƿ��Ͷ˵�ַ
    		//�ڶ����ǽ��ն˵�ַ
    		//�������Ƿ��͵��ַ���
	        //����μ�jgroup send API
    		Message msg=new Message(null, null, str); 
    		//����
			channel.send(msg);
		} catch (ChannelNotConnectedException e)
		{
			e.printStackTrace();
		} catch (ChannelClosedException e)
		{			
			e.printStackTrace();
		}
    }
    public static void main(String[] args) throws Exception 
    {
        //��ʼ�����¼�
        new Send().start();
    }
}

