package br.com.everton.wsdl;

public class MeuWebserviceProxy implements br.com.everton.wsdl.MeuWebservice {
  private String _endpoint = null;
  private br.com.everton.wsdl.MeuWebservice meuWebservice = null;
  
  public MeuWebserviceProxy() {
    _initMeuWebserviceProxy();
  }
  
  public MeuWebserviceProxy(String endpoint) {
    _endpoint = endpoint;
    _initMeuWebserviceProxy();
  }
  
  private void _initMeuWebserviceProxy() {
    try {
      meuWebservice = (new br.com.everton.wsdl.WebServiceImplServiceLocator()).getWebServiceImplPort();
      if (meuWebservice != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)meuWebservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)meuWebservice)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (meuWebservice != null)
      ((javax.xml.rpc.Stub)meuWebservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.everton.wsdl.MeuWebservice getMeuWebservice() {
    if (meuWebservice == null)
      _initMeuWebserviceProxy();
    return meuWebservice;
  }
  
  public void addTime(br.com.everton.wsdl.Time arg0) throws java.rmi.RemoteException{
    if (meuWebservice == null)
      _initMeuWebserviceProxy();
    meuWebservice.addTime(arg0);
  }
  
  public br.com.everton.wsdl.Time buscaPorNome(java.lang.String arg0) throws java.rmi.RemoteException, br.com.everton.wsdl.Exception{
    if (meuWebservice == null)
      _initMeuWebserviceProxy();
    return meuWebservice.buscaPorNome(arg0);
  }
  
  public br.com.everton.wsdl.Time[] buscaTodosTimes() throws java.rmi.RemoteException{
    if (meuWebservice == null)
      _initMeuWebserviceProxy();
    return meuWebservice.buscaTodosTimes();
  }
  
  
}