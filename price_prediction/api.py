from flask import Flask, request, jsonify
import pickle
import pandas as pd
from statsmodels.tsa.arima.model import ARIMA
from flask import Flask
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

df = pd.read_csv('pricelist.csv')
df.index.name = 'Time'

@app.route('/forecast', methods=['POST'])
def forecast():
    data = request.get_json()
    
    column_name = data.get('column_name')
    forecast_periods = data.get('forecast_periods', 10) 
    
    if column_name in df.columns:
        column_data = df[column_name]
        
        arima_model = ARIMA(column_data, order=(5, 1, 0))
        arima_model_fit = arima_model.fit()
        
        forecast = arima_model_fit.forecast(steps=forecast_periods)
        
        forecast_list = forecast.tolist()
        
        return jsonify({
            'forecast': forecast_list
        })
    else:
        return jsonify({
            'error': f"Column '{column_name}' does not exist in the DataFrame."
        }), 400

if __name__ == '__main__':
    app.run(port=8002)
