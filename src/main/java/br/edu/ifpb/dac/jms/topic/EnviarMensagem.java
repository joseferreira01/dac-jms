/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jms.topic;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 *
 * @author jose
 */
@JMSDestinationDefinition(name = "java:global/jms/exemplo",
        
        interfaceName = "javax.jms.Topic",resourceAdapter = "jmsra")
@Stateless
public class EnviarMensagem implements Serializable{
    @Resource(lookup = "java:global/jms/topic")
    private Topic topic;
    @Inject
    private JMSContext context;
    public void enviarMensagem(String email){
        JMSProducer producer = context.createProducer();
        producer.send(topic, email);
        System.out.println("mensagem"+email);
    }
}
