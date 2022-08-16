/* eslint-disable jsx-a11y/alt-text */
import './HomePageView.css'
import LongLogo from '../../graph/image/ResiduumLogoLong.png'
import {Navbar, NavbarBrand} from 'react-bootstrap';


function HomePageView()
{
    return (
        <div className='HomePageView' class="container-fluid">
            <div class="row bg-rblue1">
                <div class="col-sm">
                    <Navbar bg="rblue1">
                        <NavbarBrand>
                            <img src={LongLogo}></img>
                        </NavbarBrand>
                    </Navbar>
                </div>
            </div>
        </div>
    );
}
export default HomePageView;