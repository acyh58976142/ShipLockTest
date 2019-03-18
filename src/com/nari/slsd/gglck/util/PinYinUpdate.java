package com.nari.slsd.gglck.util;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PinYinUpdate extends JFrame
{
	public String ip = "192.168.0.231";
	public int port = 1433;
	public String db = "GGShip";
	public String user = "sa";
	public String password = "@nari2008";

	private static ComboPooledDataSource dataSource;
	private static Logger LOG = Logger.getLogger(PinYinUpdate.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -1258319110427913433L;

	private JTextField dbipField;
	private JSpinner dbportField;
	private JTextField dbField;
	private JTextField dbuserField;
	private JTextField dbpasswordField;
	private JTextField tablenameField;
	private JTextField sourcecolumnField;
	private JTextField pinyincolumnField;
	private JTextField infoField;
	private JButton button;

	public PinYinUpdate()
	{
		super("拼音生成");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new BorderLayout(20, 20));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		JPanel panel1 = new JPanel(new GridLayout(9, 1, 10, 10));

		JLabel dbipLabel = new JLabel("数据库IP");
		dbipLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		JLabel dbportLabel = new JLabel("数据库端口");
		dbportLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		JLabel dbLabel = new JLabel("数据库名称");
		dbLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		JLabel dbuserLabel = new JLabel("数据库应户名");
		dbuserLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		JLabel dbpasswordLabel = new JLabel("数据库密码");
		dbpasswordLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		JLabel tablenameLabel = new JLabel("表名");
		tablenameLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		JLabel sourcecolumnLabel = new JLabel("汉字列名");
		sourcecolumnLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		JLabel pinyincolumnLabel = new JLabel("拼音列名");
		pinyincolumnLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		JLabel intoLabel = new JLabel("输出信息");
		intoLabel.setHorizontalAlignment(SwingUtilities.CENTER);

		panel1.add(dbipLabel);
		panel1.add(dbportLabel);
		panel1.add(dbLabel);
		panel1.add(dbuserLabel);
		panel1.add(dbpasswordLabel);
		panel1.add(tablenameLabel);
		panel1.add(sourcecolumnLabel);
		panel1.add(pinyincolumnLabel);
		panel1.add(intoLabel);

		JPanel panel2 = new JPanel(new GridLayout(9, 1, 10, 10));
		panel.add(panel1, BorderLayout.WEST);
		panel.add(panel2, BorderLayout.CENTER);
		dbipField = new JTextField("192.168.0.231");
		dbportField = new JSpinner(new SpinnerNumberModel(1433, 0, 65536, 1));
		dbField = new JTextField("GGShip");
		dbuserField = new JTextField("sa");
		dbpasswordField = new JTextField("@nari2008");
		tablenameField = new JTextField("base_vessel");
		sourcecolumnField = new JTextField("vesselName");
		pinyincolumnField = new JTextField("pinyin");
		infoField = new JTextField("");
		infoField.setEditable(false);
		button = new JButton("开始");

		panel2.add(dbipField);
		panel2.add(dbportField);
		panel2.add(dbField);
		panel2.add(dbuserField);
		panel2.add(dbpasswordField);
		panel2.add(tablenameField);
		panel2.add(sourcecolumnField);
		panel2.add(pinyincolumnField);
		panel2.add(infoField);

		panel.add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				ip = dbipField.getText();
				port = (Integer)dbportField.getValue();
				db = dbField.getText();
				user = dbuserField.getText();
				password = dbpasswordField.getText();
				updateDataSource();
				String tablename = tablenameField.getText();
				String sourcecolumn = sourcecolumnField.getText();
				String pinyincolumn = pinyincolumnField.getText();

				updateVessenNameToPinyin(tablename, sourcecolumn, pinyincolumn);
			}
		});

		setContentPane(panel);
	}

	public static void main(String[] args)
	{
		new PinYinUpdate().setVisible(true);
	}

	/**
	 * base_vessel表里的船名转拼音
	 */
	public void updateVessenNameToPinyin()
	{
		updateVessenNameToPinyin("base_vessel", "vesselName", "pinyin");
	}

	public void updateVessenNameToPinyin(final String tablename, final String sourcecolumn, final String pinyincolumn)
	{
		new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				infoField.setText("已开始");

				try
				{

					String query = "SELECT " + sourcecolumn + " FROM " + tablename + " WHERE " + pinyincolumn + " IS NULL";

					List<Map<String, Object>> list = queryForList(query);
					List<Object[]> paramList = new ArrayList<Object[]>();
					for(Map<String, Object> map : list)
					{
						String name = (String)map.get("vesselName");
						String pinyin = PinYin.getPinyinFull(name);

						paramList.add(new Object[]
						{pinyin, name});
					}

					int length = paramList.size();
					int number = 0;
					List<Object[]> tempList = new ArrayList<Object[]>();
					String update = "UPDATE " + tablename + " SET " + pinyincolumn + " = ? WHERE " + sourcecolumn + " = ?";

					for(int i = 0; i < length; i++)
					{
						tempList.add(paramList.get(i));
						if(i > 0 && (i % 200 == 0 || i == length - 1))
						{
							Object[][] params = tempList.toArray(new Object[0][]);

							int[] result = batch(update, params);

							for(int r : result)
							{
								number += r;
							}

							infoField.setText("已完成" + number + "条.");
							tempList.clear();
						}
					}

					infoField.setText("完成,共" + number + "条.");
				}
				catch(Exception e)
				{
					LOG.error(e);
					infoField.setText("错误:" + e.getMessage());
				}
			}
		}).start();

	}

	public int[] batch(String sql, Object[][] params)
	{

		QueryRunner queryRunner = new QueryRunner(dataSource);
		try
		{
			return queryRunner.batch(sql, params);
		}
		catch(SQLException e)
		{
			LOG.error(e);
			throw new RuntimeException(e);
		}
	}

	public List<Map<String, Object>> queryForList(String sql)
	{

		QueryRunner queryRunner = new QueryRunner(dataSource);
		try
		{
			return queryRunner.query(sql, new MapListHandler());
		}
		catch(SQLException e)
		{
			LOG.error(e);
			throw new RuntimeException(e);
		}
	}

	private void updateDataSource()
	{
		try
		{
			if(dataSource != null)
			{
				dataSource.close();
				dataSource = null;
			}
			dataSource = new ComboPooledDataSource();

			// dataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
			dataSource.setDriverClass("net.sourceforge.jtds.jdbc.Driver");
			// dataSource.setJdbcUrl("jdbc:sqlserver://" + ip + ":" + port +
			// ";DatabaseName=" + db);
			dataSource.setJdbcUrl("jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + db);
			dataSource.setUser(user);
			dataSource.setPassword(password);
			dataSource.setMaxPoolSize(10);// 设置最大的连接数
			dataSource.setMinPoolSize(0);// 设置最小的连接数
			dataSource.setInitialPoolSize(5);// 初始化连接数
			dataSource.setAcquireIncrement(5);// 连接数的增量
		}
		catch(PropertyVetoException e)
		{
			LOG.error(e);
		}
	}

	// 获得连接
	public Connection getDbUtilConnection()
	{
		try
		{
			return dataSource.getConnection();
		}
		catch(SQLException e)
		{
			LOG.error(e);
		}
		return null;
	}

}
