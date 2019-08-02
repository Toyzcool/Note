package Eighteen;

public class ServiceFactoryImp implements ServiceFactory {
    @Override public ServiceImp getService() {
        return new ServiceImp();
    }
}
