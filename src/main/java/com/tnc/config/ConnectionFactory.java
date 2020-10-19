// package com.tnc.config;

// import java.sql.Connection;
// import java.sql.SQLException;
// import java.util.Properties;

// import javax.sql.DataSource;

// import org.apache.commons.dbcp.DriverManagerConnectionFactory;
// import org.apache.commons.dbcp.PoolableConnection;
// import org.apache.commons.dbcp.PoolableConnectionFactory;
// import org.apache.commons.dbcp.PoolingDataSource;
// import org.apache.commons.pool.impl.GenericObjectPool;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.env.Environment;

// public class ConnectionFactory {

//     private static interface Singleton {
//         final ConnectionFactory INSTANCE = new ConnectionFactory();
//     }

//     private final DataSource dataSource;

//     @Autowired
//     private Environment environment;

//     private ConnectionFactory() {
//         System.out.println("OUTPUT : " + environment.getProperty("spring.datasource.url") + " | "
//                 + environment.getProperty("spring.datasource.username") + " | "
//                 + environment.getProperty("spring.datasource.password"));

//         Properties properties = new Properties();
//         properties.setProperty("user", environment.getProperty("spring.datasource.username"));
//         properties.setProperty("password", environment.getProperty("spring.datasource.password"));

//         GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<PoolableConnection>();
//         DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
//                 environment.getProperty("spring.datasource.url"), properties);
//         new PoolableConnectionFactory(connectionFactory, pool, null, "SELECT 1", 3, false, false,
//                 Connection.TRANSACTION_READ_COMMITTED);
//         this.dataSource = new PoolingDataSource(pool);
//     }

//     public static Connection getDatabaseConnection() throws SQLException {
//         return Singleton.INSTANCE.dataSource.getConnection();
//     }

// }
