import redis.clients.jedis.Jedis;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        System.out.println("Daniel Costa - Redis Sample App with Docker");
        System.out.println("Based on: https://www.tutorialspoint.com/redis/redis_java.htm");
        System.out.println("First run docker-compose up -d on the root folder of this project.");
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());


        //set the data in redis string
        jedis.set("tutorial-name", "Redis tutorial");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));


        //store data in redis list
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // Get the stored data and print it
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);

        for(int i = 0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }


        //store data in redis list
        // Get the stored data and print it
        Object[] listkeys = jedis.keys("*").toArray();


        for(int i = 0; i<listkeys.length; i++) {
            System.out.println("List of stored keys:: "+listkeys[i].toString());
        }

    }
}
