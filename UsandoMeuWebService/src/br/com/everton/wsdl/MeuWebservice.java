/**
 * MeuWebservice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.everton.wsdl;

public interface MeuWebservice extends java.rmi.Remote {
    public void addTime(br.com.everton.wsdl.Time arg0) throws java.rmi.RemoteException;
    public br.com.everton.wsdl.Time buscaPorNome(java.lang.String arg0) throws java.rmi.RemoteException, br.com.everton.wsdl.Exception;
    public br.com.everton.wsdl.Time[] buscaTodosTimes() throws java.rmi.RemoteException;
}
