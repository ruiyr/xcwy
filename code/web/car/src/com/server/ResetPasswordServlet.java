package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constants.Constants;
import com.utils.JsonReader;

import net.sf.json.JSONObject;

/**
 *����������������
 * @author Chow
 * @since 0.0.1
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		// ��ȡ����
		try {
			PrintWriter out = response.getWriter();
			JSONObject json = JsonReader.read(request);
			String mobile = json.getString("mobile");
			String password = json.getString("password");
			System.out.println("resetpassword_mobile:" + mobile);
			System.out.println("resetpassword_password:" + password);

			Connection conn = null; // ��ǰ�����ݿ�����
			PreparedStatement pst = null;// �����ݿⷢ��sql���
			ResultSet rs = null;// �����

			try {
				Class.forName(Constants.DRIVER);
				conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME,
						Constants.DB_PASSWORD);
				String sql = "update user_table set password='" + password + "' where mobile='"
						+ mobile + "'";
				pst = conn.prepareStatement(sql);
				pst.executeUpdate();
				out.write("1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally// ��Դ����
			{
				try {
					rs.close(); // �ر�ResultSet�����
				} catch (Exception e2) {
				}
				try {
					pst.close();// �ر�Statement����
				} catch (Exception e3) {
				}
				try {
					conn.close();// �ر����ݿ�����
				} catch (Exception e4) {
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}