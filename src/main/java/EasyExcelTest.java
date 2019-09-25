import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EasyExcelTest {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new FileInputStream("D:\\java\\push_msg_test1.xlsx");
        InputStream inputStream = new BufferedInputStream(is);
        try {
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();

            ExcelReader reader = new ExcelReader(inputStream, null, listener, true);
            reader.read(new Sheet(1, 1));

            List<ArrayList> datas = listener.getDatas();
            for (ArrayList data : datas) {
                System.out.println("datas ->" + data.get(0) + "=====" + data.get(1) + "====" + data.get(2));
            }

        } catch (Exception e) {
            System.out.println(e.toString());

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
