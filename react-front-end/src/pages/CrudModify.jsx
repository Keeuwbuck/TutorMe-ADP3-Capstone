// src/pages/CrudModify.jsx
import React, { useState, useEffect } from "react";
import {
    getAllPayments,
    createPayment,
    updatePayment,
    deletePayment
} from "../api/paymentApi";

import {
    getAllReviews,
    createReview,
    updateReview,
    deleteReview
} from "../api/reviewApi";

import {
    getAllAvailabilities,
    createAvailability,
    updateAvailability,
    deleteAvailability
} from "../api/availabilityApi";

import {
    getAllSubjects,
    createSubject,
    updateSubject,
    deleteSubject
} from "../api/subjectApi";

export default function CrudModify() {
    const [activeTab, setActiveTab] = useState("User");

    const [formData, setFormData] = useState({
        User: { userId: "", firstName: "", lastName: "", phoneNumber: "", email: "", password: "" },
        University: { universityId: "", universityName: "", location: "", domain: "" },
        Tutor: { tutorID: "", hourlyRate: "", bio: "", averageRating: "", verificationStatus: "" },
        Subject: { subjectCode: "", subjectName: "", subjectDescription: "", department: "", difficultyLevel: "" },
        Student: { studentID: "", studentNumber: "", studentCourse: "", yearOfStudy: "" },
        Session: { sessionId: "", startTime: "", endTime: "", location: "", mode: "", cost: "", status: "", notes: "" },
        Review: { reviewID: "", rating: "", comment: "", dateSubmitted: "" },
        Payment: { paymentID: "", amount: "", paymentDate: "", paymentMethod: "", status: "", transactionID: "" },
        Availability: { availabilityID: "", dayOfWeek: "", startTime: "", endTime: "" },
    });

    const [paymentsList, setPaymentsList] = useState([]);
    const [reviewsList, setReviewsList] = useState([]);
    const [availabilitiesList, setAvailabilitiesList] = useState([]);
    const [subjectsList, setSubjectsList] = useState([]);

    // Load data depending on active tab
    useEffect(() => {
        if (activeTab === "Payment") {
            fetchPayments();
        } else if (activeTab === "Review") {
            fetchReviews();
        }else if (activeTab === "Subject") {
            fetchSubjects();}
        else if (activeTab === "Availability") fetchAvailabilities();
    }, [activeTab]);

    const fetchPayments = async () => {
        try {
            const data = await getAllPayments();
            setPaymentsList(data);
        } catch (err) {
            console.error("Error fetching payments:", err);
        }
    };

    const fetchReviews = async () => {
        try {
            const data = await getAllReviews();
            setReviewsList(data);
        } catch (err) {
            console.error("Error fetching reviews:", err);
        }
    };

    const fetchAvailabilities = async () => {
        try {
            const data = await getAllAvailabilities();
            setAvailabilitiesList(data);
        } catch (err) {
            console.error("Error fetching availabilities:", err);
        }
    };

    const fetchSubjects = async () => {
        try {
            const data = await getAllSubjects();
            setSubjectsList(data);
        } catch (err) {
            console.error("Error fetching subjects:", err);
        }
    };

    const handleChange = (entity, field, value) => {
        setFormData({
            ...formData,
            [entity]: { ...formData[entity], [field]: value },
        });
    };

    // CRUD Operations
    const handleSave = async (entity) => {
        try {
            if (entity === "Payment") {
                const newPayment = await createPayment(formData.Payment);
                alert("Payment created!");
                setPaymentsList(prev => [...prev, newPayment]);
            } else if (entity === "Review") {
                const newReview = await createReview(formData.Review);
                alert("Review created!");
                setReviewsList(prev => [...prev, newReview]);
            } else if (entity === "Availability") {
                const newAvailability = await createAvailability(formData.Availability);
                alert("Availability created!");
                setAvailabilitiesList(prev => [...prev, newAvailability]);
            } else if (entity==="Subject"){
                const newSubject=await createSubject(formData.Subject);
                alert("Subject created!");
                setSubjectsList(prev =>[...prev,newSubject] );
            }

            else {
                console.log("Saving new record for:", entity, formData[entity]);
            }
        } catch (err) {
            console.error(err);
            alert(`Failed to create ${entity}`);
        }
    };

    const handleUpdate = async (entity) => {
        try {
            if (entity === "Payment") {
                await updatePayment(formData.Payment);
                alert("Payment updated!");
                fetchPayments();
            } else if (entity === "Review") {
                await updateReview(formData.Review);
                alert("Review updated!");
                fetchReviews();
            }
            else if (entity === "Subject") {
                await updateSubject(formData.Subject.subjectCode,formData.Subject);
                alert("Subject updated!");
                fetchSubjects();
            }else if (entity === "Availability") {
                await updateAvailability(formData.Availability.availabilityID, formData.Availability);
                alert("Availability updated!");
                fetchAvailabilities();
            } else {
                console.log("Updating record for:", entity, formData[entity]);
            }
        } catch (err) {
            console.error(err);
            alert(`Failed to update ${entity}`);
        }
    };

    const handleDelete = async (entity) => {
        try {
            if (entity === "Payment") {
                await deletePayment(formData.Payment.paymentID);
                alert("Payment deleted!");
                setPaymentsList(prev => prev.filter(p => p.paymentID !== formData.Payment.paymentID));
            } else if (entity === "Subject") {
                await deleteSubject(formData.Subject.subjectCode);
                alert("Subject deleted!");
                setSubjectsList(prev => prev.filter(s=> s.subjectCode !== formData.Subject.subjectCode));}

            else if (entity === "Review") {
                await deleteReview(formData.Review.reviewID);
                alert("Review deleted!");
                setReviewsList(prev => prev.filter(r => r.reviewID !== formData.Review.reviewID));
            } else if (entity === "Availability") {
                await deleteAvailability(formData.Availability.availabilityID);
                alert("Availability deleted!");
                setAvailabilitiesList(prev => prev.filter(a => a.availabilityID !== formData.Availability.availabilityID));
            } else {
                console.log("Deleting record for:", entity, formData[entity]);
            }
        } catch (err) {
            console.error(err);
            alert(`Failed to delete ${entity}`);
        }
    };

    const renderForm = (entity, fields) => (
        <form className="bg-white p-6 shadow rounded-lg space-y-4">
            {/* Payment Dropdown */}
            {entity === "Payment" && paymentsList.length > 0 && (
                <select
                    className="w-full border px-3 py-2 rounded mb-4"
                    value={formData.Payment.paymentID}
                    onChange={(e) => {
                        const selected = paymentsList.find(p => p.paymentID === e.target.value);
                        setFormData(prev => ({ ...prev, Payment: selected }));
                    }}
                >
                    <option value="">Select Payment to Edit</option>
                    {paymentsList.map(p => (
                        <option key={p.paymentID} value={p.paymentID}>
                            {p.paymentID} - {p.amount} ({p.status})
                        </option>
                    ))}
                </select>
            )}

            {/* Review Dropdown */}
            {entity === "Review" && reviewsList.length > 0 && (
                <select
                    className="w-full border px-3 py-2 rounded mb-4"
                    value={formData.Review.reviewID}
                    onChange={(e) => {
                        const selected = reviewsList.find(r => r.reviewID === e.target.value);
                        setFormData(prev => ({ ...prev, Review: selected }));
                    }}
                >
                    <option value="">Select Review to Edit</option>
                    {reviewsList.map(r => (
                        <option key={r.reviewID} value={r.reviewID}>
                            {r.reviewID} - {r.rating}⭐ ({r.comment.slice(0, 15)}…)
                        </option>
                    ))}
                </select>
            )}
            {entity === "Subject" && subjectsList.length > 0 && (
                <select
                    className="w-full border px-3 py-2 rounded mb-4"
                    value={formData.Subject.subjectCode}
                    onChange={(e) => {
                        const selected = subjectsList.find(s => s.subjectCode === e.target.value);
                        setFormData(prev => ({ ...prev, Subject: selected }));
                    }}
                >

                    <option value="">Select Subject to Edit</option>
                    {subjectsList.map(s => (
                        <option key={s.subjectCode} value={s.subjectCode}>
                            {s.subjectCode} - {s.subjectName}({s.subjectDescription})
                        </option>
                    ))}
                </select>
            )}

            {entity === "Availability" && availabilitiesList.length > 0 && (
                <select
                    className="w-full border px-3 py-2 rounded mb-4"
                    value={formData.Availability.availabilityID}
                    onChange={(e) => {
                        const selected = availabilitiesList.find(a => a.availabilityID === e.target.value);
                        setFormData(prev => ({ ...prev, Availability: selected }));
                    }}
                >
                    <option value="">Select Availability to Edit</option>
                    {availabilitiesList.map(a => (
                        <option key={a.availabilityID} value={a.availabilityID}>
                            {a.dayOfWeek} ({a.startTime} - {a.endTime})
                        </option>
                    ))}
                </select>
            )}

            {fields.map((field) => (
                <div key={field}>
                    <label className="block mb-2 font-medium">{field}</label>
                    <input
                        type="text"
                        value={formData[entity][field]}
                        onChange={(e) => handleChange(entity, field, e.target.value)}
                        className="w-full border px-3 py-2 rounded"
                    />
                </div>
            ))}

            <div className="flex justify-end space-x-2">
                <button
                    type="button"
                    onClick={() => handleSave(entity)}
                    className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
                >
                    Save
                </button>
                <button
                    type="button"
                    onClick={() => handleUpdate(entity)}
                    className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700"
                >
                    Update
                </button>
                <button
                    type="button"
                    onClick={() => handleDelete(entity)}
                    className="bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700"
                >
                    Delete
                </button>
            </div>
        </form>
    );

    const entities = {
        User: ["userId", "firstName", "lastName", "phoneNumber", "email", "password"],
        University: ["universityId", "universityName", "location", "domain"],
        Tutor: ["tutorID", "hourlyRate", "bio", "averageRating", "verificationStatus"],
        Subject: ["subjectCode", "subjectName", "subjectDescription", "department", "difficultyLevel"],
        Student: ["studentID", "studentNumber", "studentCourse", "yearOfStudy"],
        Session: ["sessionId", "startTime", "endTime", "location", "mode", "cost", "status", "notes"],
        Review: ["reviewID", "rating", "comment", "dateSubmitted"],
        Payment: ["paymentID", "amount", "paymentDate", "paymentMethod", "status", "transactionID"],
        Availability: ["availabilityID", "dayOfWeek", "startTime", "endTime"],
    };

    return (
        <div className="p-6">
            <h2 className="text-3xl font-bold mb-6 text-center">Modify Records</h2>

            <div className="flex gap-4 mb-6 flex-wrap">
                {Object.keys(entities).map((entity) => (
                    <button
                        key={entity}
                        onClick={() => setActiveTab(entity)}
                        className={`px-4 py-2 rounded ${
                            activeTab === entity ? "bg-blue-600 text-white" : "bg-gray-200"
                        }`}
                    >
                        {entity}
                    </button>
                ))}
            </div>

            {renderForm(activeTab, entities[activeTab])}
        </div>
    );
}