package com.fxc.busline.busline.beans;

import com.fxc.busline.beans.BaseBean;

import java.util.List;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/25.
 */

public class BusLinesBean extends BaseBean {

	private int run_nums;
	private int avg_interval;
	private boolean has_real_bus;
	private String TicketSystem;
	private boolean IsSwipe;
	private String message;
	private List<UpBean> up;
	private List<DownBean> down;

	public int getRun_nums() {
		return run_nums;
	}

	public void setRun_nums(int run_nums) {
		this.run_nums = run_nums;
	}

	public int getAvg_interval() {
		return avg_interval;
	}

	public void setAvg_interval(int avg_interval) {
		this.avg_interval = avg_interval;
	}

	public boolean isHas_real_bus() {
		return has_real_bus;
	}

	public void setHas_real_bus(boolean has_real_bus) {
		this.has_real_bus = has_real_bus;
	}

	public String getTicketSystem() {
		return TicketSystem;
	}

	public void setTicketSystem(String TicketSystem) {
		this.TicketSystem = TicketSystem;
	}

	public boolean isIsSwipe() {
		return IsSwipe;
	}

	public void setIsSwipe(boolean IsSwipe) {
		this.IsSwipe = IsSwipe;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<UpBean> getUp() {
		return up;
	}

	public void setUp(List<UpBean> up) {
		this.up = up;
	}

	public List<DownBean> getDown() {
		return down;
	}

	public void setDown(List<DownBean> down) {
		this.down = down;
	}

	public static class UpBean {
		/**
		 * station_id : 6638
		 * station_name : 张家堡西
		 * order_number : 1
		 * running_type : 132_1
		 * bus_count : 0
		 * bus_codes :
		 */

		private String station_id;
		private String station_name;
		private int order_number;
		private String running_type;
		private int bus_count;
		private String bus_codes;

		public String getStation_id() {
			return station_id;
		}

		public void setStation_id(String station_id) {
			this.station_id = station_id;
		}

		public String getStation_name() {
			return station_name;
		}

		public void setStation_name(String station_name) {
			this.station_name = station_name;
		}

		public int getOrder_number() {
			return order_number;
		}

		public void setOrder_number(int order_number) {
			this.order_number = order_number;
		}

		public String getRunning_type() {
			return running_type;
		}

		public void setRunning_type(String running_type) {
			this.running_type = running_type;
		}

		public int getBus_count() {
			return bus_count;
		}

		public void setBus_count(int bus_count) {
			this.bus_count = bus_count;
		}

		public String getBus_codes() {
			return bus_codes;
		}

		public void setBus_codes(String bus_codes) {
			this.bus_codes = bus_codes;
		}
	}

	public static class DownBean {
		/**
		 * station_id : 6677
		 * station_name : 陕师大长安校区
		 * order_number : 1
		 * running_type : 132_2
		 * bus_count : 0
		 * bus_codes :
		 */

		private String station_id;
		private String station_name;
		private int order_number;
		private String running_type;
		private int bus_count;
		private String bus_codes;

		public String getStation_id() {
			return station_id;
		}

		public void setStation_id(String station_id) {
			this.station_id = station_id;
		}

		public String getStation_name() {
			return station_name;
		}

		public void setStation_name(String station_name) {
			this.station_name = station_name;
		}

		public int getOrder_number() {
			return order_number;
		}

		public void setOrder_number(int order_number) {
			this.order_number = order_number;
		}

		public String getRunning_type() {
			return running_type;
		}

		public void setRunning_type(String running_type) {
			this.running_type = running_type;
		}

		public int getBus_count() {
			return bus_count;
		}

		public void setBus_count(int bus_count) {
			this.bus_count = bus_count;
		}

		public String getBus_codes() {
			return bus_codes;
		}

		public void setBus_codes(String bus_codes) {
			this.bus_codes = bus_codes;
		}
	}
}
