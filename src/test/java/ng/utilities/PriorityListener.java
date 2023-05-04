package ng.utilities;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriorityListener implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> result=new ArrayList<>();

        for (IMethodInstance method : methods) {
            String [] groups  = method.getMethod().getGroups();
            if (method.getMethod().getPriority()==1 && Arrays.asList(groups).contains("regression") ){
                result.add(method);
            }
        }
        return result;
    }
}
