/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;

/**
 *
 * @author jose
 */

@Stateless
public class RecebeEmail {
    @Resource(lookup = "jms/exemplo")
    private Queue fila;
    @Inject
    private JMSContext context;
    public String lerEmail(){
        try {
            JMSConsumer consumer = context.createConsumer(fila);
            String body = consumer.receive().getBody(String.class);
            return body;
        } catch (JMSException ex) {
            Logger.getLogger(RecebeEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
       return "email não recebido";
    }
}
