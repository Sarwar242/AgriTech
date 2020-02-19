package agritech;

	public class Items {

		private int id;
		private String title;
		private String season;
	    
		private String details;
	    private byte[] img;
	 
	    
		public Items(int id, String title,String season, String details, byte[] b) {
		
			this.id = id;
			this.title = title;
			this.season=season;
			this.details = details;
			this.img = b;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getSeason() {
			return season;
		}
		public void setSeason(String season) {
			this.season = season;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		public byte[]  getImg() {
			return img;
		}
		public void setImg(byte[] img) {
			this.img = img;
		}
		

	}
