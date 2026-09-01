import React, { useState } from 'react';
import { TextField, Button, Grid, Typography } from '@mui/material';

function HrSearch({ onSearch, onReset,date,
    setDate }) {
    // const [selectedDate, setSelectedDate] = useState('');
    const [error, setError] = useState('');

    const handleDateChange = (event) => {
        setDate(event.target.value);
    };

    const handleSearch = () => {
        if (!date) {
            setError('Please select a date');
            return;
        }
        setError('');
        onSearch(date);
    };
    const handleReset = () => {
        setDate('');
        onReset();
    };


    return (
        <>
            <Grid container>
                <Grid item xs={12}>
                <Typography gutterBottom variant="h5" component="div" fontFamily="monospace">
                    Search
                    </Typography>
                </Grid>
            </Grid>
            <br></br>
            <Grid container>
                <Grid item xs={12}>
                    <TextField
                        id="date"
                        label="Select Date"
                        type="month"
                        value={date}
                        onChange={handleDateChange}
                        InputLabelProps={{
                            shrink: true,
                        }}
                    />
                </Grid>
            </Grid>
            <br></br>
            <Grid container>
                <Grid item xs={1}>
                    <Button variant="contained" onClick={handleSearch} color="success">Search</Button>
                </Grid>
                <Grid item xs={1}>
                    <Button style={{ marginLeft: "20px" }} variant="contained" onClick={handleReset} color="error">Reset</Button>
                </Grid>
                
            </Grid>
            <Grid container>

                <Grid item xs={10}>
                    {error && <p style={{ color: 'red' }}>{error}</p>}
                </Grid>
            </Grid>
        </>
    );
}

export default HrSearch;
