import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener<ArrayList> {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<ArrayList> datas = new ArrayList();

    @Override
    public void invoke(ArrayList object, AnalysisContext context) {
        System.out.println("当前行：" + context.getCurrentRowNum());
        System.out.println(object);
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(object);//根据自己业务做处理
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
    }

    public List<ArrayList> getDatas() {
        return datas;
    }

    public void setDatas(List<ArrayList> datas) {
        this.datas = datas;
    }
}