/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jms.topic;

import javax.ejb.MessageDriven;

/**
 *
 * @author jose
 */
@MessageDriven(mappedName = "java:global/jms/topic",
        @activationConfig {ActivationConfigProperty(propertiName="")} )
public class ConsumidorMensagens {
    
}
