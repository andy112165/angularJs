package angularJs;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import angularJs.avroDemo.User;

public class AvroTest {

	// @Test
	public void test() throws IOException {
		User user1 = new User();
		user1.setName("zhangsan");
		user1.setAge(10);
		user1.setPhone("1562523464");
		// 方式二 使用构造函数
		// Alternate constructor
		User user2 = new User("Ben", 7, "1556131374");
		// 方式三，使用Build方式
		// Construct via builder
		User user3 = User.newBuilder().setName("Charlie").setAge(1515).setPhone("22021313").build();
		String path = "avsc"; // avro文件存放目录
		DatumWriter<User> writer = new SpecificDatumWriter<User>();
		DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(writer);
		dataFileWriter.create(user1.getSchema(), new File(path));
		dataFileWriter.append(user1);
		dataFileWriter.append(user2);
		dataFileWriter.append(user3);
		dataFileWriter.close();
	}

	@Test
	public void read() throws IOException {
		DatumReader<User> datumReader = new SpecificDatumReader<User>();
		File file = new File("avsc");
		DataFileReader<User> dataFileReader = new DataFileReader<User>(file, datumReader);
		while (dataFileReader.hasNext()) {
			User user = (User) dataFileReader.next();
			System.out.println(user.getName());
		}
	}
}
