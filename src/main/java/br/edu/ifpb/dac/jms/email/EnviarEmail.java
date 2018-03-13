/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Queue;

/**
 *
 * @author jose
 */
@JMSDestinationDefinition(name = "jms/exemplo",
        
        interfaceName = "javax.jms.Queue",resourceAdapter = "jmsra")
@Stateless
public class EnviarEmail {
    @Resource(lookup = "jms/exemplo")
    private Queue fila;
    @Inject
    private JMSContext context;
    public void enviarEmail(String email){
        JMSProducer producer = context.createProducer();
        producer.send(fila, email);
        System.out.println("email"+email);
    }
}
