

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by bismin on 14/7/18.
 */
public class TReducer extends Reducer {



    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        int l=0;
        for (IntWritable val : values) {
            l+=1;
            sum += val.get();
        }
        sum=sum/l;
        System.out.print("the average of+"+key+"="+sum);
        context.write(key, new IntWritable(sum));
    }

}